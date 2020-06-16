/*
 *
 *
 *
 *
 *
 *
 *
 */
 
public class Cantor {
   private String type; 
   private int levels;

   public Cantor() {
      this.type = "3D";
      this.levels = 5;
   }

   public Cantor(String type, int levels) {
      this.type = type;
      this.levels = levels;
   }
      
   public static void main(String[] args) {
      String type = args[0];
      int levels = Integer.parseInt(args[1]);
      Cantor myCantor = new Cantor(type, levels);
      myCantor.run();
   }
   
   private void run() {
      if (type.equals("1D")) {
         cantor1D();
      } else if (type.equals("2D")) {
         cantor2D();
      } else if (type.equals("3D")) {
         cantor3D();
      } else {
         System.out.println("Invalid visualization type. Please choose from '1D', '2D', or '3D'.");
      }
   }
   
   private void cantor1D() {      
      PennDraw.setPenColor(PennDraw.RED);
      PennDraw.setPenRadius(0.002); 
      cantorRecursive1D(levels, 0.05, 0.9, 0.9, 0.9 / levels);
   }
      
         
   private void cantorRecursive1D(int level, double x, double y, double length, double spacing) {
      if (level < 1) {
         return;
      }
      PennDraw.line(x, y, x + length, y);
      cantorRecursive1D(level - 1, x, y - spacing, length / 3, spacing);
      cantorRecursive1D(level - 1, x + 2 * length / 3, y - spacing, length / 3, spacing);
   }
   
   private void cantor2D() {
      PennDraw.clear(PennDraw.WHITE);
      cantorRecursive2D(levels - 1, 0.2, 0.05, 0.6);
   }
   
   private static void cantorRecursive2D(int level, double x, double y, double length) {
      if (level < 1) {                                 
         PennDraw.setPenColor((int) (x * 255), (int) (y * 255), (int) (160 - (x * y * 140)));
         PennDraw.filledPolygon(x, y, 
                                x + length, y,
                                x + length, y + length,
                                x, y + length);
         return;
      }      
      cantorRecursive2D(level - 1, x, y, length / 3);
      cantorRecursive2D(level - 1, x + 2 * length / 3, y, length / 3);
      cantorRecursive2D(level - 1, x + 2 * length / 3, y + 2 * length / 3, length / 3);
      cantorRecursive2D(level - 1, x, y + 2 * length / 3, length / 3);
   }
   
   private void cantor3D() {      
      PennDraw.clear(PennDraw.BLACK);
      cantorRecursive3D(levels, 0.05, 0.2, 0.5);
   }
   
   private static void drawCube(double x, double y, double length) {
      PennDraw.setPenColor(PennDraw.BLACK);
      PennDraw.setPenRadius(0.0001);
      PennDraw.polygon(x, y, 
                       x + length, y - 0.25 * length,
                       x + length, y + length, 
                       x, y + 1.25 * length);         
      PennDraw.polygon(x + length, y - 0.25 * length,
                       x + length, y + length,
                       x + 1.82 * length, y + 1.2 * length,
                       x + 1.82 * length, y - 0.05 * length); 
      PennDraw.polygon(x, y + 1.25 * length,
                       x + length, y + length,
                       x + 1.82 * length, y + 1.2 * length, 
                       x + 0.82 * length, y + 1.45 * length);        
   }
   
   private static void fillCube(double x, double y, double length) {
      PennDraw.setPenColor(PennDraw.ORANGE);
      PennDraw.filledPolygon(x, y, 
                             x + length, y - 0.25 * length,
                             x + length, y + length, 
                             x, y + 1.25 * length);
      PennDraw.setPenColor(PennDraw.BLUE);
      PennDraw.filledPolygon(x + length, y - 0.25 * length,
                             x + length, y + length,
                             x + 1.82 * length, y + 1.2 * length,
                             x + 1.82 * length, y - 0.05 * length);
      PennDraw.setPenColor(PennDraw.MAGENTA);
      PennDraw.filledPolygon(x, y + 1.25 * length,
                             x + length, y + length,
                             x + 1.82 * length, y + 1.2 * length, 
                             x + 0.82 * length, y + 1.45 * length);
   }

      
   private static void cantorRecursive3D(int level, double x, double y, double length) {
      if (level == 1) {
         fillCube(x, y, length);   
         drawCube(x, y, length);
         return;
      }
      cantorRecursive3D(level - 1, x + length / 2, y + length / 6, length / 3);     
      cantorRecursive3D(level - 1, x + length / 2, y + 5 * length / 6, length / 3); 
      cantorRecursive3D(level - 1, x + 7 * length / 6, y, length / 3); 
      cantorRecursive3D(level - 1, x + 7 * length / 6, y + 15 * length / 24, length / 3); 
      cantorRecursive3D(level - 1, x, y, length / 3);
      cantorRecursive3D(level - 1, x, y + 2 * length / 3, length / 3);
      cantorRecursive3D(level - 1, x + 2 * length / 3, y - length / 6, length / 3);
      cantorRecursive3D(level - 1, x + 2 * length / 3, y + length / 2, length / 3);
   }
}