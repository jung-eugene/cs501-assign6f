# CS 501 Individual Assignment 6 Question 6 — Google Maps Polylines & Polygons

## Explanation

This app demonstrates how to embed **Google Maps** in a Jetpack Compose Android project and draw interactive map overlays. It includes a **polyline** representing a hiking trail and a **polygon** highlighting a park area. Both shapes use custom colors, stroke widths, and click listeners that display information through Toast messages. The Google Maps API key is stored securely in `local.properties` and injected using `manifestPlaceholders`.

## How to Use

1. Launch the app to load the map.
2. Tap the **red polyline** to see trail information.
3. Tap the **blue polygon** to view details about the selected area.
4. Zoom and pan using standard Google Maps controls.

## Implementation

* **Google Maps Compose:** `GoogleMap`, `Polyline`, and `Polygon` render all map content natively in Compose.
* **Overlays:** A red polyline and blue polygon are drawn using hard-coded coordinates.
* **Interactivity:** `clickable = true` enables Toast messages when overlays are tapped.
* **API Key Security:** The key is stored in `local.properties` (`MAPS_API_KEY`) and referenced via manifest placeholders.
* **Permissions:** Internet access is required for downloading map tiles.
