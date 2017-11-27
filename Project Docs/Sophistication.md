<div align=center>
  <h1>Sophistication</h1>
  <h2>Project Volantè</h2>
  <b> Self Driving Car </b><br />
  <b> Version <i>1.0</i></b><br />
  <b> Sophistication value of the Project + Applicability of the Project(Usefulness)</b><br />
</div><br /><br />

# Sophistication

## Purpose Of The Document:

Here, we are going to discuss what all parameters we have considered while building our product and how many parameters we have been able to cover actually. 

We promised our customers that we will be building a prototype of a self driving car which can be scaled for production.

According to whatever has been mentioned above, we have been successfully able to build our software, which meets all the requirements.

## Modules And Functions Used:

### Modules Of Cloud

* argparse
* io
* vision
* types
* json
* urllib
* sys
* time

### Modules Of Android App

* com.google.android.gms.maps.model.LatLng;
* com.google.android.gms.common.ConnectionResult;
* com.google.android.gms.common.api.GoogleApiClient;
* com.google.android.gms.location.LocationListener;
* com.google.android.gms.location.LocationRequest;
* com.google.android.gms.location.LocationServices;
* com.google.android.gms.maps.CameraUpdateFactory;
* com.google.android.gms.maps.GoogleMap;
* com.google.android.gms.maps.OnMapReadyCallback;
* com.google.android.gms.maps.SupportMapFragment;
* com.google.android.gms.maps.model.BitmapDescriptorFactory;
* com.google.android.gms.maps.model.LatLng;
* com.google.android.gms.maps.model.Marker;
* com.google.android.gms.maps.model.MarkerOptions;
* com.google.android.gms.maps.model.PolylineOptions;
* com.google.android.gms.tasks.OnFailureListener;
* com.google.android.gms.tasks.OnSuccessListener;
* com.google.firebase.storage.FirebaseStorage;
* com.google.firebase.storage.OnPausedListener;
* com.google.firebase.storage.OnProgressListener;
* com.google.firebase.storage.StorageMetadata;
* com.google.firebase.storage.StorageReference;
* com.google.firebase.storage.UploadTask;
* org.json.JSONObject;
* java.io.*;
* java.net.HttpURLConnection;
* java.net.URL;
* java.util.ArrayList;
* java.util.HashMap;
* java.util.List;


## Taking Complexity into Account:

Complexity Adjustment Values (F_i) are used on a scale of 0 (least important) to 5(most important):

1. Does the system require reliable backup and recovery?&nbsp;&nbsp;&nbsp; Value: **4**

2. Is data communication required?&nbsp;&nbsp;&nbsp;Value: **5**
3. Are there any distributed processing functions?&nbsp;&nbsp;&nbsp;Value: **0**

4. Is performance critical?&nbsp;&nbsp;&nbsp;Value: **2**

5. System to be run in an existing, heavily utilized environment?&nbsp;&nbsp;&nbsp;Value: **3**

6. Does the system require on-line data entry?&nbsp;&nbsp;&nbsp;Value: **5**

7. On-line entry requires input over multiple screens or operations?&nbsp;&nbsp;&nbsp;Value: **5**

8. Are the master files updated on-line?&nbsp;&nbsp;&nbsp;Value: **0**

9. Are the inputs, outputs, files, or inquiries complex?&nbsp;&nbsp;&nbsp;Value: **3**

10. Is the internal processing complex?&nbsp;&nbsp;&nbsp;Value: **3**

11. Is the code designed to be reusable?&nbsp;&nbsp;&nbsp;Value: **5**

12. Are conversion and installation included in the design?&nbsp;&nbsp;&nbsp;Value: **3**

13. Multiple installations in different organizations?&nbsp;&nbsp;&nbsp;Value: **4**

14. Is the application designed to facilitate change and ease-of-use?&nbsp;&nbsp;&nbsp;Value: **2**