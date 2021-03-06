# Project 1 - *Simple ToDo*

**Simple ToDo** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Tony Liu**

Time spent: **8** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **view a list of todo items**
* [x] User can **successfully add and remove items** from the todo list
* [x] User's **list of items persisted** upon modification and and retrieved properly on app restart

The following **optional** features are implemented:

* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list

The following **additional** features are implemented:

* [x] Added the upward navigation to the app so that user do not have to edit the task item in case they accidentally tap a task item and enter the edit page, and they can return back to the main page by clicking the up button in the app bar

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='to-do-app-walkthrough.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

When I was implementing the edit functionality of a particular task item, since there was no video walkthrough I could refer to, I had to look up the document provided by CodePath as well as the official Android documentation to figure out how Intent does and how to the send messages back and forth. In the process, my app crashed for a few times, since I used a function call wrong, i.e., instead of using getIntExtra, I used getStringExtra to try to retrieve an int value. But at the end, I figured it all out, and it was all worth the effort.

## License

    Copyright [2021] [Tony Liu]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
