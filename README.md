# bucketlisters-integration-protocol
Bucketlisters Integration Protocol (BLIP) is a demo backend service
facilitating the needs of our partners start their integration using our API.

### Environment Setup
1. Install git. There are a variety of ways to do this. [Here's one
   guide](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git).
2. Set up your [GitHub ssh
   keys](https://docs.github.com/en/enterprise-server@3.1/authentication/connecting-to-github-with-ssh).
3. Clone this repository to a local directory of your choosing: `$ cd
   /home/my/directory` `$ git clone
git@github.com:bucket-listers/bucketlisters-integration-protocol.git`
4. Install Java 17.
5. Install [IntelliJ IDEA](https://www.jetbrains.com/idea/download).
6. Open up this project in IntelliJ by opening the root's `build.gradle` file
   and choose to import the project.
7. Run the project

`http://localhost:8585/swagger-ui/index.html#`

## Contributing Anyone on the team is welcome to contribute.  In terms of the
actual nuts and bolts, here's the basic workflow
1. Check out the `main` branch and ensure it is fully up to date  `$ git
   checkout main`  `$ git pull`
2. Create a branch off of `main` for your work.  The general naming convention
   is to start with `feature/` or `bugfix/` depending on what you're doing, but
is not super important  `$ git checkout -b feature/my-work`
3. Do some work, adding commits to your branch  Note: Please include the JIRA
   ticket you are working on in the commit message
4. When you are ready, push your branch to Github and open up a pull request to
   merge your branch back into `main` (you can find your branch
[here](https://github.com/bucket-listers/bucketlisters-api/branches))
5. The [GitHub
   Action](https://github.com/bucket-listers/bucketlisters-api/actions) will
automatically start building your branch, ensuring all unit tests pass
6. Additionally, the code linter Qodana will run in a [GitHub
   Action](https://github.com/bucket-listers/bucketlisters-api/actions/workflows/qodana.yml)
7. After 5 & 6 have completed successfully and you have at least one approval,
   you can merge the pull request in GitHub's interface.  Note: You have the
option to squash & merge or rebase.  Use your discretion
8. Argo will automatically deploy the updated `main` branch to Staging.

### [Notion
Documentation](https://www.notion.so/bucketlisters/Bucket-Listers-Integration-Protocol-6bf09b4a95274e2c9c69ecbee6598fc8#fb1acca865274c1b8c22ec5d1d71c633)
