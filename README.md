# Gribouille

Gribouille is a simple drawing application developed using Java and JavaFX. It provides a basic canvas where users can draw freeform lines and star shapes, select colors, and adjust the thickness of the brush.

## Features

-   **Drawing Canvas:** A responsive canvas that resizes with the application window.
-   **Drawing Tools:**
    -   **Crayon (Pencil):** Draw freeform lines.
    -   **Etoile (Star):** Draw star-like shapes by clicking and dragging from a center point.
-   **Color Selection:** Choose from a predefined color palette or use a color picker for custom colors.
-   **Line Thickness:** Select from a range of line thicknesses (1-9) via the menu.
-   **Status Bar:** Displays real-time information about the mouse coordinates (X, Y), the currently selected tool, line thickness, and color.
-   **Menu System:** A menu bar for accessing tools, thickness options, and application controls.
-   **MVC Architecture:** The application is structured using a Model-View-Controller pattern, separating the data model, user interface (FXML), and control logic.

## Technologies Used

-   **Java 11**
-   **JavaFX 21**
-   **Maven**

## Getting Started

### Prerequisites

-   Java Development Kit (JDK) version 11 or later.
-   Apache Maven.

### Installation & Running

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/AtsukaDev/gribouille.git
    cd gribouille
    ```

2.  **Run the application using Maven:**
    The project is configured with the JavaFX Maven plugin. To compile and run the application, execute the following command in the project's root directory:
    ```sh
    mvn clean javafx:run
    ```

## Project Structure

The project follows a standard Maven layout and is organized using an MVC-like pattern:

-   `pom.xml`: Defines project dependencies (JavaFX) and build configurations, including the `javafx-maven-plugin` for running the app.
-   `src/main/java/iut/gon/gribouille/`:
    -   `App.java`: The main entry point for the JavaFX application.
    -   `modele/`: Contains the data model classes.
        -   `Dessin.java`: Represents the entire drawing, holding a collection of figures.
        -   `Figure.java`: An abstract base class for drawable shapes.
        -   `Trace.java`: Represents a freeform line drawn with the pencil tool.
        -   `Etoile.java`: Represents a star shape.
        -   `Point.java`: Represents a coordinate point.
    -   `controleurs/`: Contains the controller classes that manage application logic and user interactions.
        -   `Controleur.java`: The main controller that coordinates all other sub-controllers.
        -   `DessinControleur.java`: Manages the drawing canvas and mouse events.
        -   `MenusControleur.java`: Handles interactions with the menu bar.
        -   `CouleursController.java`: Manages the color selection UI.
        -   `StatutControleur.java`: Updates the status bar.
        -   `Outil.java`, `OutilCrayon.java`, `OutilEtoile.java`: Define the behavior for different drawing tools.
-   `src/main/resources/iut/gon/gribouille/`:
    -   `.fxml` files (`CadreGribouille.fxml`, `dessin.fxml`, `menus.fxml`, etc.): Define the user interface layout using FXML.
