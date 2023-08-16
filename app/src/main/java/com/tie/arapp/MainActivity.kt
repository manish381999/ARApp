package com.tie.arapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.ar.core.Config
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.PlacementMode
import io.github.sceneview.math.Position

class MainActivity : AppCompatActivity() {

    // Declare the view elements
    private lateinit var sceneView: ArSceneView
    private lateinit var placeButton: ExtendedFloatingActionButton
    private lateinit var modelNode: ArModelNode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        initializeViews()

        // Set up the AR scene
        setupARScene()

        // Set up UI event listeners
        setupUIListeners()
    }

    // Initialize views from XML layout
    private fun initializeViews() {
        sceneView = findViewById(R.id.sceneView)
        placeButton = findViewById(R.id.place)
    }

    // Configure the AR scene
    private fun setupARScene() {
        // Disable light estimation for performance
        sceneView.lightEstimationMode = Config.LightEstimationMode.DISABLED

        // Create an AR model node
        modelNode = ArModelNode(sceneView.engine, PlacementMode.INSTANT).apply {
            loadModelGlbAsync(
                glbFileLocation = "models/sofa_single.glb",
                scaleToUnits = 1f,
                centerOrigin = Position(-0.5f)
            ) { loadedModel ->
                // Handle model loading completion
                // Show the plane renderer to indicate surface detection
                sceneView.planeRenderer.isVisible = true
                val materialInstance = loadedModel.materialInstances[0]
            }
            // Hide the place button when an anchor is changed
            onAnchorChanged = { anchor ->
                placeButton.isGone = anchor != null
            }
        }
        // Add the model node to the AR scene
        sceneView.addChild(modelNode)
    }

    // Set up UI event listeners
    private fun setupUIListeners() {
        // Set a click listener for the place button
        placeButton.setOnClickListener {
            // Place the model and hide the plane renderer
            placeModel()
        }
    }

    // Place the 3D model on the detected surface
    private fun placeModel() {
        modelNode.anchor()
        sceneView.planeRenderer.isVisible = false
    }
}
