package de.saxsys.swingvsfx.performance;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import de.saxsys.swingvsfx.swing.SwingPerformanceFrame;

public class PerformanceTester {

    private final ThreadMXBean bean = ManagementFactory.getThreadMXBean();

    public PerformanceResult testPerformanceAtInit(IPerformanceComponent panel, IPerformanceContainer frame) {
        long start = bean.getCurrentThreadCpuTime();

        panel.initPerformancPanel();
        frame.addPerformancePanel(panel.getComponent());

        long end = bean.getCurrentThreadCpuTime();
        return new PerformanceResult(start, end);
    }

    
    
    public PerformanceResult testPerformanceAtUpdate(IPerformanceComponent panel) {
        long start = bean.getCurrentThreadCpuTime();

        panel.updatePerformancePanel();

        long end = bean.getCurrentThreadCpuTime();
        return new PerformanceResult(start, end);
    }

    
    
    
    public void testAddPerformancePanel(final Object performancePanel, final IPerformanceContainer frame) {
        long start = bean.getCurrentThreadCpuTime();

        JComponent panel = (JComponent) performancePanel;
        ((JTabbedPane) frame.getPaneToAdd()).add("Performance-Test", panel);

        long end = bean.getCurrentThreadCpuTime();
        PerformanceResult r = new PerformanceResult(start, end);
        System.out.println(r.getPerformanceInSeconds());
    }
}
