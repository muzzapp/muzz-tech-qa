# Muzz QA Technical Test
## Congratulations, you have reached the next stage which is a technical test.
##### Please create your own repo and share the solution with us.

### Description
Let’s start!

We are in the middle of the sprint and the following tasks were just moved to the QA testing column on our board, Manual team have tested and now want Automation to automate the following scenarios:

##
### 1 - As a user I want to log in to the app

Given - The user opens the app for the first time (when not logged in yet)

Then - The login screen with user name and password entries and login button is displayed

#### Scenario 2 - User login failed

Given - The user provided wrong user name and/or password

When - The Login button is clicked

Then - The error markers are displayed by user name and/or password entries

#### Scenario 3 - User login succeed (credentials provided below)

Given - The user provided correct credentials

When - Login button is clicked

Then - User is taken to the discover profiles screen

#### Scenario 4 - User opens app next time (when previously logged in)

Given - The user opens app next time (when previously logged in)

Then - User is taken straight to the discover screen

 ##

### 2 - As a user I want to like dating profiles

#### Scenario 1 - Profiles are loaded

Given - The user successfully logged in to the app

When - There is internet connection

Then - Profiles are displayed

#### Scenario 2 - Failed to Profiles

Given - The user successfully logged in to the app

When - There is no internet connection

Then - “Failed to profiles” error message is displayed with a Retry button

#### Scenario 3 - liking profiles

Given - The dating profiles are successfully loaded on the screen

When - The user likes one or more of the profiles

Then - after 5 lkes/passes, the user should see the correct number of profiles liked

#### Login credentials:
#### user: user
#### password: password

##

We expect that these functions will be tested both manually and automatically by you.

### Manual tests - We expect that any bugs will be reported in clear form

### Automated tests - Using jetpack compose test or any other tool of your choosing (explain why)

* At Muzz we love clean code so please try to write your tests neatly.

* It’s not mandatory but using an additional abstraction level for your tests (like POM or your own framework to facilitate writing tests) will be very much appreciated

* As a note, we won't consider any automation task submission created with a test recorder.

At Muzz we highly appreciate good communication at all times. If you have any questions, please don’t hesitate to ask us :)

### Next Steps
Once we have received your test along with any other documentation which you feel is necessary for your submission, we will review it. If we like what we see, we'll invite you into our office for
a face to face discussion where we’ll ask you to go through your test, explaining any decisions that you've made.

## Good luck!
