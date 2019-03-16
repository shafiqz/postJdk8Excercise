package com.saz.sorter.gui;

import com.saz.sorter.api.SorterProvider;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {

    private JLabel sizeLabel;
    private JComboBox<String> arraySizeComboBox;
    private JButton startButton;
    private JTable table;
    private ExecutorService threadPool = Executors.newFixedThreadPool(threadPoolSize());
    private List<SorterProvider> sorterProviders = new ArrayList<>(0);
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public MainPanel() {
        super(true);

        initializeGuiComponents();
        doSubComponentLayout();

        setBorder(BorderFactory.createCompoundBorder());

        Supplier<Void> callBack = () -> {
            sortMultipleSorters();
            return null;
        };

        startButton.addActionListener(new ButtonActionListener(callBack));
    }

    private void initializeGuiComponents() {

        sizeLabel = new JLabel("Array size");

        var arraySizes = new String[]{"10000", "20000", "30000"};
        arraySizeComboBox = new JComboBox<>(arraySizes);
        arraySizeComboBox.setSelectedIndex(0);

        startButton = new JButton("Start");
        sorterProviders = loadSorterProviders();

        var algoNames = getAlgoNames(sorterProviders);
        var columnValues = produceColumnValues(algoNames).toArray(new String[][]{});
        var columnNames = new String[] {"Algorithmn Name", "Status"};

        table = new JTable(columnValues, columnNames);
        table.setFillsViewportHeight(true);
    }

    private void doSubComponentLayout() {
        var layoutManager = new GridBagLayout();
        setLayout(layoutManager);

        var constraint = new GridBagConstraints();
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.weightx = 0.5;
        add(sizeLabel, constraint);

        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 0;
        add(arraySizeComboBox, constraint);

        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 2;
        constraint.gridy = 0;
        add(startButton, constraint);

        var scrollPane = new JScrollPane(table);
        constraint.fill = GridBagConstraints.BOTH;
        constraint.gridx = 0;
        constraint.gridy = 1;
        constraint.gridwidth = 3;
        constraint.weightx = 1;
        constraint.weighty = 1;
        add(scrollPane, constraint);
    }

    private List<SorterProvider> loadSorterProviders() {

        var sorterProviders = ServiceLoader.load(SorterProvider.class);

        var listOfSorterProviders = new ArrayList<SorterProvider>();
        for (var provider : sorterProviders) {
            listOfSorterProviders.add(provider);
        }

        return listOfSorterProviders;
    }

    private List<String> getAlgoNames(List<SorterProvider> sorterProviders) {

        return sorterProviders.
               stream().
               map(SorterProvider::getName).
               collect(Collectors.toList());
    }

    private List<String[]> produceColumnValues(List<String> algoNames) {

        return algoNames.
               stream().
               map(algoName -> new String[] {algoName, "Not started"}).
               collect(Collectors.toList());
    }

    private static class ButtonActionListener implements ActionListener {

        private final Supplier<Void> callBack;

        public ButtonActionListener(Supplier<Void> callBack) {
            this.callBack = callBack;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            callBack.get();
        }
    }

    private static class DoneSortingCallBack implements Function<Long, Void> {

        private final JTable table;
        private final int rowIndex;
        private final AtomicInteger sorterInOperationCount;
        private final JButton startButton;


        public DoneSortingCallBack(JTable table, int rowIndex,
                                   AtomicInteger sorterCount,
                                   JButton button) {
            this.table = table;
            this.rowIndex = rowIndex;
            this.sorterInOperationCount = sorterCount;
            this.startButton = button;
        }

        @Override
        public Void apply(Long aLong) {

            String timeTakenText = aLong.toString() + " ms";
            SwingUtilities.invokeLater(() -> table.setValueAt(timeTakenText, rowIndex, 1));

            if (sorterInOperationCount.decrementAndGet() <= 0) {
                SwingUtilities.invokeLater(() -> startButton.setEnabled(true));
            }

            return null;
        }
    }

    private static int threadPoolSize() {
        var size = Runtime.getRuntime().availableProcessors() - 1;

        return size <= 0 ? 1 : size;
    }

    private void sortMultipleSorters() {

        try {

            var size = Integer.parseInt(arraySizeComboBox.getSelectedItem() + "");
            Integer[] array = new Integer[size];
            for (int i = 0; i <= array.length - 1; ++i) {
                array[i] = random.nextInt();
            }

            startButton.setEnabled(false);
            var sorterInOperationCount = new AtomicInteger(0);

            for (var i = 0; i < sorterProviders.size(); ++i) {
                var sp = sorterProviders.get(i);

                var callBack = new DoneSortingCallBack(table, i,
                                                       sorterInOperationCount,
                                                       startButton);
                sorterInOperationCount.incrementAndGet();
                final int idx = i;
                SwingUtilities.invokeLater(() -> table.setValueAt("Sorting...", idx, 1));
                threadPool.submit(new ExecuteSorter(sp.getSorter(),
                                                    array, callBack));

            }
        }
        catch (NumberFormatException nfe) {
            System.out.println("Unable to retrieve arraySize");
        }
    }
}
