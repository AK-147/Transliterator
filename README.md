<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>
  <img src="https://github.com/AK-147/Transliterator/blob/main/TransliteratorGUI/assets/banner.png?raw=true" alt="Banner"/>
  
  <h2>:book: Description</h2>
  <ul>
    <li>:capital_abcd: A program that converts English characters to their phonetic counterparts in the Arabic grapheme system.</li>
    <li>:newspaper: Has a text-based user interface for use in command line and a graphical user interface made with Java Swing.</li>
    <li>:scroll: Made whilst studying the Arabic language, greatly testing my knowledge of the syntax and morphology.</li>
  </ul>

  <h2>:file_folder: Contents</h2>
  <p>
    Navigating to the <strong>src</strong> folder, we can ignore all the files contained within the <strong>bin</strong> folder.
    There are two main project folders, each with its own nested files:
  </p>
  <ul>
    <li><strong>Transliterator</strong> has a text-based user interface that can be launched via the command terminal.
      <ul>
        <li><strong>All_In_One.java</strong> is the initial iteration of the program all contained in a single file.</li>
        <li><strong>Core.java</strong> is a version that refers to another class rather than being all in one file.</li>
        <li><strong>Index.java</strong> acts as the database that is referred to for all the character conversions.</li>
      </ul>
    </li>
    <li><strong>TransliteratorGUI</strong> holds a graphical user interface application utilizing the Java Swing API.
      <ul>
        <li><strong>Assets</strong> is a folder containing all the required images and icons for the application.</li>
        <li><strong>AppCore.java</strong> consists of all the code for compiling the graphical user interface.</li>
        <li><strong>AppIndex.java</strong> behaves likewise, as a database to be referred to by the other classes.</li>
        <li><strong>AppTransliterator.java</strong> executes the main logic behind the transliteration of characters.</li>
      </ul>
    </li>
  </ul>

  <h2>:arrow_down: Installation</h2>
  <p>
    To use the text-based version via the command terminal, switch to the correct directory and run either <strong>All_In_One.class</strong>
    or <strong>Core.class</strong> from the <strong>bin</strong> folder through the designated command, for which there are plenty of guides online.
    If you have an accredited Java IDE such as Eclipse or IntelliJ, you can simply open or copy and paste the files and run the program there instead.
  </p>
  <p>
    For using the graphical interface, it is best to run <strong>AppTransliterator.java</strong> as the driver class through a Java IDE.
    This program was created in Eclipse, heavily utilizing the Java Swing library along with others. So to get optimal results,
    it would be best to recreate the project in a similar environment which fulfills the necessary requirements for the program to run.
  </p>
  <h2></h2>
  <h3>Enjoy - استمتع</h3>
</body>
</html>
