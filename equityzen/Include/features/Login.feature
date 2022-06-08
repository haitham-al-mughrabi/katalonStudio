#Feature: Login testing
#
  #Scenario: Login using correct cridentials
  #	When the user visit or redirected to login page 
    #When Clicks on login button
      #| buttonName | targetPage | mutifunction | srcHolder      |
      #| Login      | login      | true         | mutliUseButton |
    #Then The user should be in login page
    #When The user enter correct credentials
      #| email                        | password                 | targetPage |
      #| quality+global@equityzen.com | W+b/J7R9rwqd5mSb6/XXRA== | login      |
    #And Clicks on submit button
      #| buttonName | targetPage | mutifunction | srcHolder      |
      #| Submit     | login      | true         | mutliUseButton |
    #Then The user should be in listings page
  #	When the user visit or redirected to Home Page
  #	
    #
#
#Object Repository/Visiter view/Home Page