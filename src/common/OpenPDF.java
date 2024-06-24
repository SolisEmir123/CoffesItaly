/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author emiry
 */
public class OpenPDF {

    public static void openById(String id) {
        try {
            String userHome = System.getProperty("user.home");
            String filePath = userHome + File.separator + "Documents" + File.separator + id + ".pdf";
            File pdfFile = new File(filePath);

            if (pdfFile.exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler " + pdfFile.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no existe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
