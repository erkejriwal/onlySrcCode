package javapractice.javaadvanced;

import java.applet.*;
import java.awt.*;
import java.net.*;

public class ImageDemo extends Applet {
   private Image image;
   private AppletContext context;
   
   public void init() {
      context = this.getAppletContext();
      String imageURL = this.getParameter("image");
      if(imageURL == null) {
         imageURL = "http://d1hyf4ir1gqw6c.cloudfront.net//wp-content/uploads/DFS.jpg";
      }
      try {
         URL url = new URL(this.getDocumentBase(), imageURL);
         image = context.getImage(url);
      }catch(MalformedURLException e) {
         e.printStackTrace();
         // Display in browser status bar
         context.showStatus("Could not load image!");
      }
   }
   
   public void paint(Graphics g) {
      context.showStatus("Displaying image");
      g.drawImage(image, 0, 0, 500, 400, null);
      g.drawString("www.javalicense.com", 35, 100);
   }  
}