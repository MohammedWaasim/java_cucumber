#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Investment Test
  I want to use this template for my feature file

  @Invest_Test_Scenario
  Scenario: To verify SPDR under Portfolio is 50 percent
  Given I launch beta version of model-portfolio
  And I navigate to Explore Portfolio screen
  When I change the SPDR slider to "50" percent and click on 'Rebalance'
  Then I verify SPDR is set to "50" percent on suggestions screen