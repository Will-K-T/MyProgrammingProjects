#include <bits/stdc++.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include <sys/types.h>
#include <sys/wait.h>

using namespace std;

char* cmd1[] = {(char*)"ls", nullptr};
char* cmd2[] = {(char*)"tr", (char*)"a-z", (char*)"A-Z", nullptr};

int main(){
    int fds[2];
    pipe(fds);

    pid_t pid1 = fork();
    if(!pid1){
      dup2(fds[1], 1);
      //close(fds[0]);
      execvp(cmd1[0], cmd1);
    }

    pid_t pid2 = fork();
    if(!pid2){
      dup2(fds[0], 0);
      //close(fds[1]);
      execvp(cmd2[0], cmd2);
    }

    //close(fds[0]);
    //close(fds[1]);

    int status = 0;
    waitpid(pid1, &status, 0);
    cout << "over" << endl;
}
