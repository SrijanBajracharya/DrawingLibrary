# DrawingLibrary

***Drawing Library***
```
Drawing library is a small console application developed in Java which doesnot use any other libraries.
```

***Introduction***
```
Drawing library is a small console application which helps user to draw different shapes 
like rectangles, lines inside a canvas.It also provides a funcionality of flood fill or 
bucket fill similar to that in paint application. This application is user interactive and 
informs user about various input consequences. for example: if user tries to draw a rectangle 
with coordinate x1=6 y1=0 x2=6 y2=2, this application will reply saying "you are trying to draw a rectangle".
```
***Commands***

***To draw Canvas***
```
c height width
```

***To draw Rectangle***
```
r x1,y1,x2,y2
```

***To draw line***
```
l x1,y1,x2,y2
```

***For bucket fill***
```
b x y c

where x and y is the point and c is the character which you want to fill canvas with.
```

***Installation***
```
Drawing Library is developed using JRE-1.8 and it doesnot use any other libraries.
Hence eclipse IDE is enough to run the application.
```

***Features***
```
1) Allows user to draw only one canvas and displays message if user tries to draw another canvas.
2) Allows user to draw multiple rectangles and lines inside the canvas.
3) If lines form a shape of rectangle with canvas boundary then it is treated as rectangle.
   for example: if canvas[5][5] and line is l 4 0 4 4 then it is treated as rectangle
4) while bucket fill it checks and fills accordingly
```
