# 490_Senior_Project
COSC 490 Vaccine App 

ACM Word Doc for MyVaxPass
 
 
Carl Levine Jr
Morgan State University
Baltimore Maryland
Calev1@morgan.edu
 



 
ABSTRACT
In this paper, we will look at the creation of the vaccine passport app and its inner workings and functionalities. 
CCS Concepts
• Information systems---Data management systems---Database design and models-- -App-based database models 
Keywords
MYSQL, Android studio, Java, Database, App, android, application, user, user interface, admin, admin interface, login, Vaccine, google drive, security, validation 
1.	INTRODUCTION
This project is an android application that will allow the user to create and replicate and official CDC backed vaccine passport. This application would serve to work how the vaccine cards given to any recipient of a COVID-19 vaccine shot. However, the use of this vaccine app will work as a more convenient and easily searchable, changeable, and valid digital vaccine card for the user. 
2.	PAGE SIZE
All material on each page should fit within a rectangle of 18 × 23.5 cm (7" × 9.25"), centered on the page, beginning 1.9 cm (0.75") from the top of the page and ending with 2.54 cm (1") from the bottom.  The right and left margins should be 1.9 cm (.75").   
The text should be in two 8.45 cm (3.33") columns with a .83 cm (.33") gutter.
3.	TYPESET TEXT
3.1	Normal or Body Text
 Permission to make digital or hard copies of all or part of this work for personal or classroom use is granted without fee provided that copies are not made or distributed for profit or commercial advantage and that copies bear this notice and the full citation on the first page. To copy otherwise, or republish, to post on servers or to redistribute to lists, requires prior specific permission and/or a fee.
Conference’10, Month 4 2022, Baltimore, Maryland, United States.
Copyright 2022 ACM 1-58113-000-0/00/0010 …$15.00.
Please use a 9-point Times Roman font, or other Roman font with serifs, as close as possible in appearance to Times Roman in which these guidelines have been set. The goal is to have a 9-point text, as you see here. Please use sans-serif or non-proportional fonts only for special purposes, such as distinguishing source code text. If Times Roman is not available, try the font named Computer Modern Roman. On a Macintosh, use the font named Times.  Right margins should be justified, not ragged.
3.2	First Page Copyright Notice
Please leave 3.81 cm (1.5") of blank text box at the bottom of the left column of the first page for the copyright notice.
3.3	Subsequent Pages
For pages other than the first page, start at the top of the page, and continue in double-column format.  The two columns on the last page should be as close to equal length as possible.

3.4	FIGURES/CAPTIONS
Place Tables/Figures/Images in text as close to the reference as possible (see Figure 1).  It may extend across both columns to a maximum width of 17.78 cm (7”).
Captions should be Times New Roman 9-point bold.  They should be numbered (e.g., “Table 1” or “Figure 2”), please note that the word for Table and Figure are spelled out. Figure’s captions should be centered beneath the image or picture, and Table captions should be centered above the table body.
4.	SECTIONS

The heading of a section should be in Times New Roman 12-point bold in all-capitals flush left with an additional 6-points of white space above the section head.  Sections and subsequent sub- sections should be numbered and flush left. For a section head and a subsection head together (such as Section 3 and subsection 3.1), use no additional space above the subsection head.
4.1	ACKNOWLEDGMENTS
Our thanks to ACM SIGCHI for allowing us to modify templates they had developed.
5.	REFERENCES
5.1	References
Codeplayon. 2018. Android Image UpLoad to server From Camera and gallery - Codeplayon. [online] Available at: <https://www.codeplayon.com/2018/11/android-image-upload-to-server-from-camera-and-gallery/> [Accessed 20 April 2022].
GeeksforGeeks. 2020. How to Read Data from SQLite Database in Android? - GeeksforGeeks. [online] Available at: <https://www.geeksforgeeks.org/how-to-read-data-from-sqlite-database-in-android/?ref=lbp> [Accessed 20 April 2022].
GeeksforGeeks. 2021. How to Create and Add Data to SQLite Database in Android? - GeeksforGeeks. [online] Available at: <https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/> [Accessed 20 April 2022].
GeeksforGeeks. 2021. How to Select an Image from Gallery in Android? - GeeksforGeeks. [online] Available at: <https://www.geeksforgeeks.org/how-to-select-an-image-from-gallery-in-android/> [Accessed 20 April 2022].
Mihn Tran, N., 2022. Create a Database Android Application in Android Studio 3.0 - DZone Mobile. [online] dzone.com. Available at: <https://dzone.com/articles/create-a-database-android-application-in-android-s> [Accessed 20 April 2022].
SupportNpp, T., 2019. How to Create Multi User Login Apps in Android using Android Studio. [online] Youtube.com. Available at: <https://www.youtube.com/watch?v=zSgrMVt_MFg> [Accessed 20 April 2022].



 

 
App Layout:
Login Screen:
This Page is the official landing page. Here the user or and admin will be able to log in with their effective accounts

Main Screen:
This Page is where the user can add the virtual vaccine card info and even upload a photo of the physical vaccine card. They can then add this to the database where the admin can go and confirm their vaccine status. 

View Screen:
This screen is where the user can go to see all the vaccine cards they have uploaded, and the admin can also view and see all the vaccine cards that have been uploaded by the user. 

Update Screen:
This screen is where the user can go to update visible information on the card and the admin can go and add in the display of the status of the vaccine card. 

Delete Button:
This button would allow for the user to delete any selected vaccine card they have uploaded.

MYSQL Database:
This is where all the user vaccine card information will be stored and used to display for the view screen. 


Setup: 
This project is housed in the development ide of android studio. It is a popular ide used to create android and iOS app programs. This vaccine passport app is an android app that would allow for the user to carry a CDC certified virtual passport of their COVID-19 vaccine information. Within the program itself you can see a few different methods and functionalities put in place to create this app. We see several activities that represent the screens each user will be brought to throughout their time on the app. We also see the use of various classes functions and methods to create the ability for many of the functionalities in the app to work. For any user that runs this application the setup is simply. When you run the app, you will be prompted to log in either as a user or an admin. If you log in as a user, you will be taken to the main screen. This is where you can add all your desired/required vaccine information to be on your virtual card. Once this is done you can then move on to the view screen where you can view all vaccine cards you have uploaded. Once this is done you also have the functionality to edit or delete the card after it has been uploaded. Moving over to the admin side of things. Once you log in as an admin you will be immediately directed to the view screen where you can view all the user uploads. This is where you can then go into each individual upload, verify all the correct information is there and you can accept or deny any card that does not have that already displayed on screen. Given that this app is not a fully produced production product there are a few things that need to be addressed.  

Troubles and issues. Given this project there were many issues that were encountered during development time. Most of which have been sorted out. However, there is still one small/medium issue that is still plaguing the project. This comes in during the uploading the image portion of the vaccine card. Given that one of the options for uploading an image can be done through google drive. There happens to be an issue with the instance of the data once the session is over. So, for example, and this will be shown in the presentation. When the user uploads the image and adds the card to the database. You can go and view the card and see the image there. However, once you end the session and you log back in as either a user or and admin and you try to launch the view screen. You will be met with a security issue error that stops this from happening. This is because again due to the nature of google drive and how the permissions work once that initial session where you use the data is over you no longer have the permissions to view said image data. Now I have seen a few possible fixes for the solution. Sadly, none of the given solutions where able to fix this problem and I did not have enough time to find one. You can still see the image URI being displayed if a user does upload a card which signifies that there is something there so I have stuck with this route which again will be explained in the demo. 


