import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;

public class ViewLibrarianPanel extends JPanel
{
   private JTable table;
   private JScrollPane scrollPane;

   public ViewLibrarianPanel(AbstractTableModel model)
   {
      super(new BorderLayout());
      setPreferredSize(new Dimension(View.WIDTH, View.HEIGHT));
      setBorder(BorderFactory.createTitledBorder("Librarians"));

      table = new JTable(model);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      scrollPane = new JScrollPane(table);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      add(scrollPane, BorderLayout.CENTER);
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      LibrarianTableModel model = new LibrarianTableModel();
      ViewLibrarianPanel panel = new ViewLibrarianPanel();

      frame.add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
