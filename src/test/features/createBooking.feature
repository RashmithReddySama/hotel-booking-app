@wip
Feature: Create and Delete Bookings

  Scenario: Create a new booking
    Given I am on the hotel booking form page
    When I create the following bookings
      | First name | Surname | Price | Deposit | Check in   | Check out  |
      | Rashmith   | Reddy   | 99    | true    | 2018-05-10 | 2018-05-15 |
      | Sanjana    | Reddy   | 129   | true    | 2018-05-15 | 2018-05-20 |
    Then I should see the bookings created on the list of bookings
      | First name |
      | Rashmith   |
      | Sanjana    |

  Scenario: Delete a booking
    Given I am on the hotel booking form page
    When I delete recently created bookings
      | First name |
      | Sanjana    |
      | Rashmith   |
    Then the bookings should be deleted from the list of bookings

