package blserial;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.ViewLogin;

public class Main {
    public static void main(String args[]) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
   //UIManager.setLookAndFeel(new PampaLookAndFeel());
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }

                 UIManager.put("nimbusBase", new Color(255, 99, 57));
                 UIManager.put("nimbusBlueGrey", new Color(255, 255, 255));
    //             UIManager.put("control", new Color(253, 245, 230));
     //             UIManager.put("control", new Color(110, 102, 255));
    EventQueue.invokeLater(new Runnable()
    {
      @Override
      public void run()
      {
                 
        new ViewLogin().setVisible(true);
      }
    });
    }
}

