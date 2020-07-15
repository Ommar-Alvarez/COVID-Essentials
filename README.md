# COVID Essentials
  This repository contains an assigned project done for a Java Programming graduate course at the University of Nevada, Las Vegas. The project prompt was simple: create an innovative application that solves a real-world issue. The project was assigned briefly before univerisity classess became remote and COVID-19 quarantine restrictions came into effect in Las Vegas, Nevada.

Given the fact that businesses in the Las Vegas Metropolitan Area will eventually reopen as the pandemic comes to an end, a gif demonstration is provided below to give a visual exam

## Purpose
  The intention of the COVID Essentials application is to provide users with a seamless experience in their search for businesses that continue to offer their services despite quarantine restrictions that may alter their business practice. It is an application with the intention of making the dissemination of information to consumers easier by taking Yelp a step further to only provide results for businesses that are still open during times of quarantine.

## Back End Development
COVID Essentials can be simplified as using a request-response application design that leverages the power of the current Yelp Fusion (v3) API. Using a private API key distributed by Yelp for open-source application development, our application is able to authenticate API calls to the millions of businesses, across 32 countries, that the Yelp database maintains a record of. We intend to develop a seamless graphical interface in order for users to use our application.

Yelp’s Fusion API current consists of six endpoints, though our application will leverage the following five:
  - Business Search—Search for businesses by keyword, category, location, price level, ​etc.
  - Phone Search—Search for businesses by phone number.
  - Business Details—Business data such as name, address, phone number, photos, Yelp rating, price levels and hours of operation.
  - Business Match—Uses business data from other sources to match with Yelp businesses.
  - Reviews—Review excerpts for businesses.
  
  COVID Essentials requires four important criteria to initiate search activity. These
criteria consist of the arguments <i>term</i>, ​location​, ​price, ​and​ limit​. The ​term​ argument provides the variable of interest that serves as the basis for the business search (​e.g. ​restaurant, retailer, or any other service indicator). ​Location​ and ​price ​arguments​ s​ erve as the variables that indicate specific preferences of the client that will serve as parameters for filtration. The ​limit​ argument indicates the “search limit,” or the desired number of hits that the user expects to choose from.
  As summarized in the ​Figure 1 f​ lowchart, once these criteria are entered into the application’s fields, these criteria are tokenized and fed into an HTTP builder, which builds a URL then sends a request to the Yelp Fusion API for information that fits the criteria. The Yelp Fusion API then translates these criteria into a GraphQL query that makes a call to Yelp’s vast database for instances that fit these criteria; more specifically, the query calls for the five aforementioned endpoints of instances that suit the criteria. Once the query is complete, the Yelp