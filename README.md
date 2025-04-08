
<h1>Programming 2 - Shop Management System (Early)</h1>
<h2>To-Do List</h2>
<ul>
  <li>
    Add an attribute to the product class to do with the stock sold amount.
    <ul>
      <li>Update this whenever stock is sold.</li>
      <li>Make it so that the PDF creator checks said attribute, if it is not zero then display said item in the PDF.</li>
    </ul>
  </li>
  <li>
    Convert the display to a table so that the product info can be shown in seperate columns.
    <ul>
      <li>Make the table.</li>
      <li>Make it uneditable.</li>
      <li>Fix previous logic to add data to the different columns.</li>
      <li>We may have to give products indexes to prevent things from going wrong somehow, so we could also add an index attribute to the product class, assign a valid index on product creation, add this as a hidden column on the table and refer to this when deleting products from the arraylist as well. I've got code for this from my CW1.3 so that can be used (on my GitHub).</li>
    </ul>
  </li>
</ul>
<h2><u>Setting up IntelliJ</u></h2>
<p>Install IntelliJ from <a href="https://www.jetbrains.com/idea/download/">here</a>. Select "Clone Repository".</p>
<img alt="Clone repository" src="Documentation/images/Install-1.jpg">
<p>Select "Programming-2-CW2" from the menu, you may have to login to GitHub for this option to show.</p>
<img alt="Select from menu" src="Documentation/images/Install-2.jpg">
<p>The IDE may not let you run the Java files or may not even show the src directory, to fix this, navigate to the hamburger menu -> FIle -> Repair IDE.</p>
<img alt="Repair IDE" src="Documentation/images/Install-3.jpg">
<p>Select "Rescan Project Indexes" in the bottom right.</p>
<img alt="Rescan project indexes" src="Documentation/images/Install-4.jpg">
<p>Select "Reopen Project" in the bottom right.</p>
<img alt="Rescan project" src="Documentation/images/Install-5.jpg">
<p>You might have to select your Java SDK as well, this can be done by navigating to the settings menu in the top right -> Project Structure -> Project. Select the SDK dropdown and either select an existing one or select "Download JDK...", this automatically downloads one and selects it for you.</p>
<p>That's it, the project should be runnable now. You'll have to add the libraries below as well.</p>
<img alt="Rescan project" src="Documentation/images/Install-6.jpg">
<h2><u>Dependencies</u></h2>
<p><a href="https://github.com/HannanAFC/Programming-2-CW2/releases/download/dependencies/dependencies.zip">Download ZIP</a></p>
<p>To add the dependencies the to project, download the ZIP file and extract it.</p>
<img alt="Extract ZIP" src="Documentation/images/Step-1.jpg">
<p>The contents should look like this.</p>
<img alt="ZIP contents" src="Documentation/images/Step-2.jpg">
<p>In IntelliJ, click on the hamburger menu in the top left -> File -> Project Structure -> Modules and press the plus symbol</p>
<img alt="Add libraries" src="Documentation/images/Step-3.png">
<p>Navigate to the where you extracted the dependencies and select all of them.</p>
<img alt="Select libraries" src="Documentation/images/Step-4.jpg">
<p>Next, make sure to check the checkbox for the added libraries and select "apply" and then "Ok".</p>
<img alt="Apply changes" src="Documentation/images/Step-5.png">
<p>And that's it. The classes should now be recognised by the IDE.</p>



