package org.app;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.SwingUtilities;

import org.app.forms.MainForm;
import org.app.library.ExceptionManager;
import org.app.library.FileManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        try { SwingUtilities.invokeLater(new MainForm()); }
        catch (Exception ex) {
            try { 
                FileManager.of("data/log")
                    .write(
                        String.format(
                            "system_error_%s.log", 
                            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))
                        ), 
                        ExceptionManager.read(ex).getBytes()
                    ); 
            }
            catch (IOException e) { }
        }
    }
}