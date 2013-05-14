
package org.jfree.chart.demo;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a Gantt chart.
 * <P>
 * This demo is intended to show the conceptual approach rather than being a polished
 * implementation.
 *
 *
 */
public class GanttDemo1 extends ApplicationFrame {

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public GanttDemo1(final String title) {

        super(title);

        final IntervalCategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        


        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Creates a sample dataset for a Gantt chart.
     *
     * @return The dataset.
     */
    public static IntervalCategoryDataset createDataset() {

    	
    /*	start Time: 2012-03-11 11:15:41.0, end Time: 2012-03-11 11:16:04.0, activity: Unknown
    	start Time: 2012-03-11 11:16:05.0, end Time: 2012-03-11 11:16:10.0, activity: Unknown
    	start Time: 2012-03-11 11:16:11.0, end Time: 2012-03-11 13:19:36.0, activity: Weather
    	start Time: 2012-03-11 13:19:37.0, end Time: 2012-03-11 13:22:19.0, activity: Returning
    	start Time: 2012-03-11 13:22:20.0, end Time: 2012-03-11 13:25:31.0, activity: Unknown
    	start Time: 2012-03-11 13:25:32.0, end Time: 2012-03-11 13:26:27.0, activity: Unknown
    	start Time: 2012-03-11 13:26:28.0, end Time: 2012-03-11 13:26:43.0, activity: Unknown
    	start Time: 2012-03-11 13:26:44.0, end Time: 2012-03-11 13:26:54.0, activity: Unknown
    	start Time: 2012-03-11 13:26:55.0, end Time: 2012-03-11 13:27:03.0, activity: Unknown
    	start Time: 2012-03-11 13:27:04.0, end Time: 2012-03-11 13:27:10.0, activity: Unknown
    	start Time: 2012-03-11 13:27:11.0, end Time: 2012-03-11 13:27:21.0, activity: Unknown
    	start Time: 2012-03-11 13:27:22.0, end Time: 2012-03-11 13:27:25.0, activity: Unknown
    	start Time: 2012-03-11 13:27:26.0, end Time: 2012-03-11 13:27:29.0, activity: Unknown
    	start Time: 2012-03-11 13:27:30.0, end Time: 2012-03-11 13:28:23.0, activity: Unknown
    	start Time: 2012-03-11 13:28:24.0, end Time: 2012-03-11 13:31:00.0, activity: Loading
    	start Time: 2012-03-11 13:31:01.0, end Time: 2012-03-11 13:41:32.0, activity: Hauling
    	start Time: 2012-03-11 13:41:33.0, end Time: 2012-03-11 13:41:38.0, activity: Unknown
    	start Time: 2012-03-11 13:41:39.0, end Time: 2012-03-11 13:41:50.0, activity: Unknown
    	start Time: 2012-03-11 13:41:51.0, end Time: 2012-03-11 13:41:56.0, activity: Unknown
    	start Time: 2012-03-11 13:41:57.0, end Time: 2012-03-11 13:42:05.0, activity: Unknown
    	start Time: 2012-03-11 13:42:06.0, end Time: 2012-03-11 13:42:17.0, activity: Unknown
    	start Time: 2012-03-11 13:42:18.0, end Time: 2012-03-11 13:42:40.0, activity: Unknown
    	start Time: 2012-03-11 13:42:41.0, end Time: 2012-03-11 13:43:41.0, activity: Unknown
    	start Time: 2012-03-11 13:43:42.0, end Time: 2012-03-11 13:44:14.0, activity: Unknown
    	start Time: 2012-03-11 13:44:15.0, end Time: 2012-03-11 13:44:18.0, activity: Unloading
    	start Time: 2012-03-11 13:44:19.0, end Time: 2012-03-11 13:45:58.0, activity: Returning
    	start Time: 2012-03-11 13:45:59.0, end Time: 2012-03-11 13:46:31.0, activity: Unknown
    	start Time: 2012-03-11 13:46:32.0, end Time: 2012-03-11 13:50:17.0, activity: Unknown
    	start Time: 2012-03-11 13:50:18.0, end Time: 2012-03-11 13:50:21.0, activity: Unknown
    	start Time: 2012-03-11 13:50:22.0, end Time: 2012-03-11 13:53:21.0, activity: Returning
    	start Time: 2012-03-11 13:53:22.0, end Time: 2012-03-11 13:57:11.0, activity: Unknown
    	start Time: 2012-03-11 13:57:12.0, end Time: 2012-03-11 13:58:03.0, activity: Unknown
    	start Time: 2012-03-11 13:58:04.0, end Time: 2012-03-11 13:58:12.0, activity: Unknown
    	start Time: 2012-03-11 13:58:13.0, end Time: 2012-03-11 13:58:25.0, activity: Unknown
    	start Time: 2012-03-11 13:58:26.0, end Time: 2012-03-11 13:58:47.0, activity: Unknown
    	start Time: 2012-03-11 13:58:48.0, end Time: 2012-03-11 13:58:51.0, activity: Unknown
    	start Time: 2012-03-11 13:58:52.0, end Time: 2012-03-11 13:58:58.0, activity: Unknown*/

    	
    	
        final TaskSeries s1 = new TaskSeries("Scheduled");
        s1.add(new Task("Unkdnown",  new SimpleTimePeriod(date("2012-03-11 11:15:35"),
                                    date("2012-03-11 11:15:40"))));
        
        s1.add(new Task("Weather",
               new SimpleTimePeriod(date("2012-03-11 11:16:11"),
                                    date("2012-03-11 13:19:36"))));
/*        
        s1.add(new Task("Requirements Analysis",
               new SimpleTimePeriod(date(10, Calendar.APRIL, 2001),
                                    date(5, Calendar.MAY, 2001))));
        s1.add(new Task("Design Phase",
               new SimpleTimePeriod(date(6, Calendar.MAY, 2001),
                                    date(30, Calendar.MAY, 2001))));
        s1.add(new Task("Design Signoff",
               new SimpleTimePeriod(date(2, Calendar.JUNE, 2001),
                                    date(2, Calendar.JUNE, 2001))));
        s1.add(new Task("Alpha Implementation",
               new SimpleTimePeriod(date(3, Calendar.JUNE, 2001),
                                    date(31, Calendar.JULY, 2001))));
        s1.add(new Task("Design Review",
               new SimpleTimePeriod(date(1, Calendar.AUGUST, 2001),
                                    date(8, Calendar.AUGUST, 2001))));
        s1.add(new Task("Revised Design Signoff",
               new SimpleTimePeriod(date(10, Calendar.AUGUST, 2001),
                                    date(10, Calendar.AUGUST, 2001))));
        s1.add(new Task("Beta Implementation",
               new SimpleTimePeriod(date(12, Calendar.AUGUST, 2001),
                                    date(12, Calendar.SEPTEMBER, 2001))));
        s1.add(new Task("Testing",
               new SimpleTimePeriod(date(13, Calendar.SEPTEMBER, 2001),
                                    date(31, Calendar.OCTOBER, 2001))));
        s1.add(new Task("Final Implementation",
               new SimpleTimePeriod(date(1, Calendar.NOVEMBER, 2001),
                                    date(15, Calendar.NOVEMBER, 2001))));
        s1.add(new Task("Signoff",
               new SimpleTimePeriod(date(28, Calendar.NOVEMBER, 2001),
                                    date(30, Calendar.NOVEMBER, 2001))));

        final TaskSeries s2 = new TaskSeries("Actual");
        s2.add(new Task("Write Proposal",
               new SimpleTimePeriod(date(1, Calendar.APRIL, 2001),
                                    date(5, Calendar.APRIL, 2001))));
        s2.add(new Task("Obtain Approval",
               new SimpleTimePeriod(date(9, Calendar.APRIL, 2001),
                                    date(9, Calendar.APRIL, 2001))));
        s2.add(new Task("Requirements Analysis",
               new SimpleTimePeriod(date(10, Calendar.APRIL, 2001),
                                    date(15, Calendar.MAY, 2001))));
        s2.add(new Task("Design Phase",
               new SimpleTimePeriod(date(15, Calendar.MAY, 2001),
                                    date(17, Calendar.JUNE, 2001))));
        s2.add(new Task("Design Signoff",
               new SimpleTimePeriod(date(30, Calendar.JUNE, 2001),
                                    date(30, Calendar.JUNE, 2001))));
        s2.add(new Task("Alpha Implementation",
               new SimpleTimePeriod(date(1, Calendar.JULY, 2001),
                                    date(12, Calendar.SEPTEMBER, 2001))));
        s2.add(new Task("Design Review",
               new SimpleTimePeriod(date(12, Calendar.SEPTEMBER, 2001),
                                    date(22, Calendar.SEPTEMBER, 2001))));
        s2.add(new Task("Revised Design Signoff",
               new SimpleTimePeriod(date(25, Calendar.SEPTEMBER, 2001),
                                    date(27, Calendar.SEPTEMBER, 2001))));
        s2.add(new Task("Beta Implementation",
               new SimpleTimePeriod(date(27, Calendar.SEPTEMBER, 2001),
                                    date(30, Calendar.OCTOBER, 2001))));
        s2.add(new Task("Testing",
               new SimpleTimePeriod(date(31, Calendar.OCTOBER, 2001),
                                    date(17, Calendar.NOVEMBER, 2001))));
        s2.add(new Task("Final Implementation",
               new SimpleTimePeriod(date(18, Calendar.NOVEMBER, 2001),
                                    date(5, Calendar.DECEMBER, 2001))));
        s2.add(new Task("Signoff",
               new SimpleTimePeriod(date(10, Calendar.DECEMBER, 2001),
                                    date(11, Calendar.DECEMBER, 2001))));
*/
        final TaskSeriesCollection collection = new TaskSeriesCollection();
        collection.add(s1);
/*        collection.add(s2);
*/
        return collection;
    }

    /**
     * Utility method for creating <code>Date</code> objects.
     *
     * @param day  the date.
     * @param month  the month.
     * @param year  the year.
     *
     * @return a date.
     */
    private static Date date(final int day, final int month, final int year) {

        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        final Date result = calendar.getTime();
        return result;

    }
    
    
    private static Date date(String str) {

    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
    	Date dt = null;
		try {
			dt = sdf.parse(str);
			System.out.print("date1: " + dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);

        final Date result = calendar.getTime();
        System.out.println(", date2: " + result);
        return result;

    }
        
        
    /**
     * Creates a chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createChart(final IntervalCategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createGanttChart(
            "Gantt Chart Demo",  // chart title
            "Task",              // domain axis label
            "Date",              // range axis label
            dataset,             // data
            true,                // include legend
            true,                // tooltips
            false                // urls
        );    
//        chart.getCategoryPlot().getDomainAxis().setMaxCategoryLabelWidthRatio(10.0f);
        
        
		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
		//CategoryItemRenderer categoryitemrenderer = categoryplot.getRenderer();
		//categoryitemrenderer.setSeriesPaint(0, new Color(0x4D6BA3));
		//categoryplot.setDataset(collection);

		DateAxis axis = (DateAxis) categoryplot.getRangeAxis();
		axis.setTickUnit(new DateTickUnit(DateTickUnitType.MINUTE,30));

        return chart;    
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final GanttDemo1 demo = new GanttDemo1("Gantt Chart Demo 1");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}

 