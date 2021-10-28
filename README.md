ABSTRACT:

A music player Application is made using Android Studio which has the following functionalities:
•	Pause
•	Play
•	Stop
•	Forward 
•	Rewind
Details of the song
•	The name of the song being displayed
•	The progress of the song being displayed using a seek bar
•	Time elapsed in the song
•	Time remaining in the song

INTRODUCTION:

Android :
Android is an open source and Linux-based Operating System for mobile devices such as smartphones and tablet computers. Android was developed by the Open Handset Alliance, led by Google, and other companies.
Android offers a unified approach to application development for mobile devices which means developers need only develop for Android, and their applications should be able to run on different devices powered by Android.
The first beta version of the Android Software Development Kit (SDK) was released by Google in 2007 where as the first commercial version, Android 1.0, was released in September 2008.
On June 27, 2012, at the Google I/O conference, Google announced the next Android version, 4.1 Jelly Bean. Jelly Bean is an incremental update, with the primary aim of improving the user interface, both in terms of functionality and performance.
The source code for Android is available under free and open source software licenses. Google publishes most of the code under the Apache License version 2.0 and the rest, Linux kernel changes, under the GNU General Public License version 2.

Android Studio: 
Android Studio is the official integrated development environment (IDE) for Google's Android operating system, built on JetBrains' IntelliJ IDEA software and designed specifically for Android development. It is available for download on Windows, macOS and Linux based operating systems or as a subscription-based service in 2020.

The following features are provided in the current stable version: 
•	Gradle-based build support
•	Android-specific refactoring and quick fixes
•	Lint tools to catch performance, usability, version compatibility and other problems
•	ProGaurd integration and app-signing capabilities
•	Template-based wizards to create common Android designs and components
•	A rich layout editor that allows users to drag-and-drop UI components, option to preview layouts on multiple screen configurations
•	Support for building Android Wear apps
•	Built-in support for Google Cloud Platform, enabling integration with Firebase Cloud Messaging (Earlier 'Google Cloud Messaging') and Google App Engine
•	Android Virtual Device (Emulator) to run and debug apps in the Android studio

Application components:

 Application components are the essential building blocks of an Android application. These components are loosely coupled by the application manifest file AndroidManifest.xml that describes each component of the application and how they interact.

No	Components & Description
1	Activities
They dictate the UI and handle the user interaction to the smart phone screen.
2	Services
They handle background processing associated with an application.
3	Broadcast Receivers
They handle communication between Android OS and applications.
4	Content Providers
They handle data and database management issues.


Additional Components:

There are additional components which will be used in the construction of above mentioned entities, their logic, and wiring between them. These components are 

No	Components & Description
1	Fragments
Represents a portion of user interface in an Activity.
2	Views
UI elements that are drawn on-screen including buttons, lists forms etc.
3	Layouts
View hierarchies that control screen format and appearance of the views.
4	Intents
Messages wiring components together.
5	Resources
External elements, such as strings, constants and drawable pictures.
6	Manifest
Configuration file for the application.


CODE:
The MediaPlayer class is used to play sound and video in the Android framework.This class is the primary API for playing sound and video.
The methods used in the program are:
•	Musicplay
•	musicpause
•	musicstop
•	musicrevind
•	musicff

UI elements used are:
•	Button-pause
•	Button-start
•	Button-stop
•	Button-revind
•	Button-ff
•	Button-prev
•	Button-next
•	TextView-Toast
•	TextView-songinfo
•	TextView-txtStartTime
•	TextView-txtSongTime
•	SeekBar-sBar

A runnable thread is used to update the elapsed song time, remaining song time and to update the seek bar.

private Runnable UpdateSongTime = new Runnable() {
    public void run() {
        sTime = music.getCurrentPosition();
        txt1.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) sTime),
                TimeUnit.MILLISECONDS.toSeconds((long) sTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                toMinutes((long) sTime)))
        );
        songPrgs.setProgress((int)sTime);
        myHandler.postDelayed(this, 100);
    }
};
  
Adding the music file to our app: the mp3 file is added to the raw folder. 
