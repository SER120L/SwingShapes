# Shape Graphics

Shape objects for graphics work.
Designed for Swing but can most likely be used with other Java graphical libraries.
Call any shape's `paint` method to draw it on any Swing component (requires a `Graphics2D` object instance).

To use, just take the classes you need.

## Line

The `Line` class creates a line shape. Color, thickness, location and rotation can be set. The line's x1, y1, x2, and y2 must be defined at initialization.

```java
Line line = new Line(10, 10, 70, 70);
```

The `GenericShape` class must be included to use this shape.

## Rectangle

The `Rectangle` class creates a rectangular shape. Fill color, border color, border thickness, location, width, height, and rotation can be set.

```java
Rectangle rectangle = new Rectangle();
```

The `RectangleShape` class must be included for this shape.

## Ellipse

The `Ellipse` class creates a circular shape. Fill color, border color, border thickness, location, width, height, and rotation can be set.

```java
Ellipse ellipse = new Ellipse();
```

Additionally, there's a cutInHalf field, which when set to true will cut the ellipse in half, creating a "half circle".

The `EllipseShape` and `RectangleShape` classes must be included for this shape.

## RoundedRectangle

The `RoundedRectangle` class creates a rectangle shape with rounded corner arcs. Fill color, border color, border thickness, location, width, height, and rotation can be set. The corner arc size can be defined at initialization.

```java
RoundedRectangle roundedRectangle = new RoundedRectangle();    // default corner arc size
RoundedRectangle roundedRectangle2 = new RoundedRectangle(25); // specified corner arc size
```

The `RectangleShape` class must be included for this shape.

## Triangle

The `Triangle` class creates a triangular shape. Fill color, border color, border thickness, location, scale, and rotation can be set.


```java
Triangle triangle = new Triangle();             // default equilateral triangle
Triangle triangle2 = new Triangle(50);          // equilateral triangle of custom side lengths
Triangle triangle3 = new Triangle(40, 30);      // isosceles triangle (height, base)
Triangle triangle4 = new Triangle(40, 30, 60);  // custom-sized triangle (side1, side2, side3)
```

The `PolygonShape` class must be included for this shape.

## Pentagon

The `Pentagon` class creates a pentagon shape. Fill color, border color, border thickness, location, scale, and rotation can be set.

```java
Pentagon pentagon = new Pentagon();             
```

The `PolygonShape` class must be included for this shape.
