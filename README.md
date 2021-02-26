# L4806
Sysc4806 Lab

https://travis-ci.com/github/Souheil-Yazji/L4806/builds/216881695  
https://addressbook4806l.herokuapp.com/


In the latest commit, one thing that still doesn't work is displaying the contents of a previously created addressbook after requesting the contents of another. The presistence was checked previously just using postman and the controllers, which showed that the data was being presisted. In line 14 of main.js, the data.buddyInfos is null. This is likely the cause of the problem. 
