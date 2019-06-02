**************************Selenium Coding challenge part 3- Naveen Automation Labs************************************

Important Points:
1. All configuration data required is placed in "config.properties" file which is available in src\main\java\com\crm\config
2. The test can run in both chrome and firefox browsers
3.This script is capable Headless mode.
4.Browserand Headless mode  can be onfigured using "config.properties"
5.Please execute this program from testng.xml
6.Browser exe driver files are available in directory path itself

***************************Working of Program**********************************************************************
Test Case 1(divided into two tests)
1) go to this url -https://naveenlabs.capsulecrm.com/login?
a. Login with correct credentials
2) click on person icon and add a person
3) click on cases icon
4) click on Add Case button
5) Create a new case with the added person
6) Verify the correct case got created for the same
person
7) verify the case status: Open
8) close the browser
Test Case 2:
1) go to this url -https://naveenlabs.capsulecrm.com/login?
a. Login with correct credentials
2) click on account name at left top corner
3) go to account settings
4) Verify Account Settings page header
5) Click on each link available at left panel:
Account Settings
? Account
? Invoices

? Export
? Appearance
? Mail Drop Box
? Users
? Opportunities
? Tracks
? Task Categories
? Custom Fields
? Tags
? Integrations
? Trash
6). After clicking on each link, verify the page header
7) Click on Appearance and upload a logo image
8) Click on Users : Add New User and verify the same
user
9) Click on Opportunities : Add new milestone and
verify the same
10) Click on Tracks : Add new track and verify the
same
11) Click on Task Categories : Add new category and
verify the same
12) Click on Tags : Add new milestone and verify the
same
13) Click on Integrations and verify total number of Configure buttons
14) close the browser