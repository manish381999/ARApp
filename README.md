# AR App with 3D Object Placement

This Android app demonstrates the usage of ARCore to place a 3D object on a detected real-world surface. The app also includes basic GLSL shader effects for modifying the appearance of the 3D object.

## Getting Started

Follow the steps below to set up and run the project locally on your development machine.

### Prerequisites

- Android Studio (latest version recommended)
- Android device or emulator with ARCore support

### Installation

1. Clone the repository to your local machine:


2. Open Android Studio and select "Open an existing Android Studio project."

3. Navigate to the cloned project directory and select the `arapp` folder.

4. Build and run the app on your Android device.

### Usage

1. Launch the app on your Android device.

2. Point the camera at a flat surface to detect and visualize it in the AR view.

3. Tap the "Place" button to place the 3D object on the detected surface.

4. Interact with the placed 3D object using gestures such as pinch-to-scale and swipe-to-rotate.

### Customization

- You can replace the 3D model by replacing the `sofa_single.glb` file located in the `app/src/main/assets/models` directory with your own GLB model.

### Troubleshooting

- If the app crashes or doesn't work as expected, ensure that you have granted camera permissions to the app and that your device supports ARCore.

## Contributing

Contributions are welcome! If you find any issues or want to enhance the app, feel free to create pull requests.
