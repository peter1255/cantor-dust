# cantor-dust
The Cantor set is formed by iteratively removing the middle third from the interval [0,1], then removing the middle third from the remaining segments [0, 1/3) U (2/3, 1], and continuing ad infinitum. 

The 2D version is achieved by taking the double cartesian product of the standard Cantor set, while the 3D version is done using the triple cartesian product. 

The program uses self-similar transformations to recursively remove each middle third. For true Cantor dust, the number of iterations must go to infinity, though in this program seven or eight iterations is enough to get the desired effect. 

Cantor dust has many topologically interesting properties, including zero measure.    

### Dependencies
PennDraw.java

### Execution
```
java Cantor dimension iterations
```
where dimensions is either 1D, 2D, or 3D and iterations is an integer greater than zero. E.g.:  
```
java Cantor 3D 6
```
