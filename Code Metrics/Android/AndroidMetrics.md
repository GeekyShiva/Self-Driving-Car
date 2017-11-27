# Code Metrics For Android App

The following code metrics have been calculated using MetricsReloaded :: JetBrains Plugin Repository.

## 1. Metrics for whole project

### MOOD Metrics

| Project | AHF | AIF | CF | MHF | MIF | PF |
|----------|-------|--------|-------------|-------------|-------------|-------------|
|"project" | 43.75% | 90.03% | 60.00% | 29.31% | 0.00% | 100.00% | 

### Lines Of Code Metrics

| Package | LOC |  LOCp | LOCt |
|----------|-------|--------|-------------|
| com.tanmaypatil.selfdrivingcar | 1027 |   992 | 35 |
| drawable | 254 | 254 | 0 |
| drawable-v24|34 | 34|0 |
| layout | 127 | 127 | 0 |
| menu | 20 | 20 | 0 |
| mipmap-anydpi-v26 | 10 |10 |0 |
| values | 50 |50 |0 |
| values-v21 | 1 | 1| 0|
| Total| 1523 | 1488 | 35 |
| Average| 190.38|186 | 4.38|



## 2. Metrics for classes

|Class|OCavg|WMC
|----------|-------|--------|
|com.tanmaypatil.selfdrivingcar.CameraPreview|2.40|12
|com.tanmaypatil.selfdrivingcar.Data|1.00|10
|com.tanmaypatil.selfdrivingcar.DirectionsJSONParser|5.50|11
|com.tanmaypatil.selfdrivingcar.ExampleInstrumentedTest|1.00|1
|com.tanmaypatil.selfdrivingcar.ExampleUnitTest|1.00|1
|com.tanmaypatil.selfdrivingcar.MapsActivity|1.94|68
|com.tanmaypatil.selfdrivingcar.MapsActivity.DownloadTask|1.00|2
|com.tanmaypatil.selfdrivingcar.MapsActivity.ParserTask|2.00|4


## 3. Metrics for methods

### Complexity Metrics

Method|ev(G)|iv(G)|v(G)
|----------|-------|--------|-------------|
|com.tanmaypatil.selfdrivingcar.CameraPreview.CameraPreview(Context,Camera,CameraInfo,int)|2|1|3
|com.tanmaypatil.selfdrivingcar.CameraPreview.calculatePreviewOrientation(CameraInfo,int)|2|2|6
|com.tanmaypatil.selfdrivingcar.CameraPreview.surfaceChanged(SurfaceHolder,int,int,int)|2|4|4
|com.tanmaypatil.selfdrivingcar.CameraPreview.surfaceCreated(SurfaceHolder)|1|2|2
|com.tanmaypatil.selfdrivingcar.CameraPreview.surfaceDestroyed(SurfaceHolder)|1|1|1
|com.tanmaypatil.selfdrivingcar.Data.getCurrentHeading()|1|1|1
|com.tanmaypatil.selfdrivingcar.Data.getCurrentLocation()|1|1|1
|com.tanmaypatil.selfdrivingcar.Data.getDiffHeading()|1|1|1
|com.tanmaypatil.selfdrivingcar.Data.getDirection()|1|1|1
|com.tanmaypatil.selfdrivingcar.Data.getJsonObject()|1|1|1
|com.tanmaypatil.selfdrivingcar.Data.makeJSON()|1|2|2
|com.tanmaypatil.selfdrivingcar.Data.setCurrentHeading(float)|1|1|1
|com.tanmaypatil.selfdrivingcar.Data.setCurrentLocation(LatLng)|1|1|1
|com.tanmaypatil.selfdrivingcar.Data.setDiffHeading(float)|1|1|1
|com.tanmaypatil.selfdrivingcar.Data.setDirection(String)|1|1|1
|com.tanmaypatil.selfdrivingcar.DirectionsJSONParser.decodePoly(String)|1|4|6
|com.tanmaypatil.selfdrivingcar.DirectionsJSONParser.parse(JSONObject)|1|6|7
|com.tanmaypatil.selfdrivingcar.ExampleInstrumentedTest.useAppContext()|1|1|1
|com.tanmaypatil.selfdrivingcar.ExampleUnitTest.addition_isCorrect()|1|1|1
|com.tanmaypatil.selfdrivingcar.MapsActivity.DownloadTask.doInBackground(String...)|1|2|2
|com.tanmaypatil.selfdrivingcar.MapsActivity.DownloadTask.onPostExecute(String)|1|1|1
|com.tanmaypatil.selfdrivingcar.MapsActivity.ParserTask.doInBackground(String...)|1|2|2
|com.tanmaypatil.selfdrivingcar.MapsActivity.ParserTask.onPostExecute(List<List<HashMap<String, String>>>)|1|4|4
|com.tanmaypatil.selfdrivingcar.MapsActivity.buildGoogleApiClient()|1|1|1
|com.tanmaypatil.selfdrivingcar.MapsActivity.checkLocationPermission()|2|3|3
|com.tanmaypatil.selfdrivingcar.MapsActivity.downloadUrl(String)|1|3|3
|com.tanmaypatil.selfdrivingcar.MapsActivity.getCameraInstance(int)|1|2|2
|com.tanmaypatil.selfdrivingcar.MapsActivity.getDirectionsUrl(LatLng,LatLng)|1|1|1
|com.tanmaypatil.selfdrivingcar.MapsActivity.makeDataForGCP()|3|7|20
|com.tanmaypatil.selfdrivingcar.MapsActivity.onAccuracyChanged(Sensor,int)|1|1|1
|com.tanmaypatil.selfdrivingcar.MapsActivity.onBackPressed()|1|2|2
|com.tanmaypatil.selfdrivingcar.MapsActivity.onConnected(Bundle)|1|2|2
|com.tanmaypatil.selfdrivingcar.MapsActivity.onConnectionFailed(ConnectionResult)|1|1|1
|com.tanmaypatil.selfdrivingcar.MapsActivity.onConnectionSuspended(int)|1|1|1
|com.tanmaypatil.selfdrivingcar.MapsActivity.onCreate(Bundle)|1|2|2
|com.tanmaypatil.selfdrivingcar.MapsActivity.onCreateOptionsMenu(Menu)|1|1|1
|com.tanmaypatil.selfdrivingcar.MapsActivity.onLocationChanged(Location)|1|3|3
|com.tanmaypatil.selfdrivingcar.MapsActivity.onMapReady(GoogleMap)|1|9|9
|com.tanmaypatil.selfdrivingcar.MapsActivity.onNavigationItemSelected(MenuItem)|1|1|2
|com.tanmaypatil.selfdrivingcar.MapsActivity.onOptionsItemSelected(MenuItem)|1|1|1
|com.tanmaypatil.selfdrivingcar.MapsActivity.onPause()|1|1|1
|com.tanmaypatil.selfdrivingcar.MapsActivity.onResume()|1|1|1
|com.tanmaypatil.selfdrivingcar.MapsActivity.onSensorChanged(SensorEvent)|1|1|1
|com.tanmaypatil.selfdrivingcar.MapsActivity.releaseCamera()|1|2|2
|com.tanmaypatil.selfdrivingcar.MapsActivity.sendImageToGCP()|1|4|5
|com.tanmaypatil.selfdrivingcar.MapsActivity.sendJSONToGCP()|1|3|3


## 4. Legends

|Metric | Description |
|----- |----|
| AHF| Attribute Hiding Factor |
| AIF| Attribute Inheritance Factor|
| CF| Coupling Factor|
| MHF| Method Hiding Factor|
| MIF|Method Inheritance Factor |
| PF| Polymorphism Factor|
| LOC| Lines Of Code|
| LOCp| Total lines of source code minus blank lines and comment lines|
| LOCt| LOCt measures the lines in a call tree|
| OCavg| Average Operation Complexity|
| WMC| Weighted Method per class|
| ev(g)| Essential Complexity Metric|
| iv(g)| Module Design Complexity Metric|
| v(g)| Cyclomatic Complexity|
