# COVID Essentials
  This repository contains an assigned project done for a Java Programming graduate course at the University of Nevada, Las Vegas. The project prompt was simple: create an innovative application that solves a real-world issue. The project was assigned briefly before univerisity classess became remote and COVID-19 quarantine restrictions came into effect in Las Vegas, Nevada.

Given the fact that businesses in the Las Vegas Metropolitan Area will eventually reopen as the pandemic comes to an end, a visual demonstration is provided in the gif below:
![Farmers Market Finder Demo](https://photos.app.goo.gl/CkC1a4ftJ67hphAs7)

## Purpose
  The intention of the COVID Essentials application is to provide users with a seamless experience in their search for businesses that continue to offer their services despite quarantine restrictions that may hinder operating hours. It is an application with the intention of making the dissemination of information to consumers easier by taking Yelp a step further to only provide results for businesses that are still open during times of quarantine.

## Back End Development
COVID Essentials can be simplified as using a request-response application design that leverages the power of the current Yelp Fusion (v3) API. Using a private API key distributed by Yelp for open-source application development, the application is able to authenticate API calls to the millions of businesses, across 32 countries, that the Yelp database maintains a record of.

Yelp’s Fusion API current consists of six endpoints, though the application will leverage the following five:
  - Business Search—Search for businesses by keyword, category, location, price level, <i>etc.</i>
  - Phone Search—Search for businesses by phone number.
  - Business Details—Business data such as name, address, phone number, photos, Yelp rating, price levels and hours of operation.
  - Business Match—Uses business data from other sources to match with Yelp businesses.
  - Reviews—Review excerpts for businesses.
  
  COVID Essentials requires four important criteria to initiate search activity. These criteria consist of the arguments <i>term</i>, <i>location</i>, <i>price</i>, and <i>limit</i>. The <i>term</i> argument provides the variable of interest that serves as the basis for the business search (<i>e.g.</i> restaurant, retailer, or any other service indicator). <i>Location</i> and <i>price</i> arguments serve as the variables that indicate specific preferences of the client that will serve as parameters for filtration. The <i>limit</i> argument indicates the “search limit,” or the desired number of hits that the user expects to choose from.

  As summarized in the <i>Figure 1</i> flowchart, once these criteria are entered into the application’s fields, these criteria are tokenized and fed into an HTTP builder, which builds a URL then sends a request to the Yelp Fusion API for information that fits the criteria. The Yelp Fusion API then translates these criteria into a GraphQL query that makes a call to Yelp’s vast database for instances that fit these criteria; more specifically, the query calls for the five aforementioned endpoints of instances that suit the criteria. Once the query is complete, the Yelp database then responds to the COVID Essential application by parsing the queried data into a JSON format, which is then returned back to the client. Before returning query results back to the owner, the JSON file is stylized into an intelligible format that the client can easily interpret.<br>
<img src="../master/demo/figure1.png" alt="fig1">
  
### Framework
  COVID Essentials was composed using IntelliJ IDEA as the interactive development environment of choice, and heavily rely on the Maven core java framework. Maven offers the convenience of easily downloading project dependency libraries, as well as creating builds.

### Modules
  The following modules were included in COVID Essentials’ development, the majority of which being JAR files relating to API interaction and the GUI:
    - Okhttp-3.6.0
    - Okio-1.11.0
    - Java-json
    - Javax.swing
    In order for COVID Essentials to utilize the implemented API, OkHttp is used as the HTTP client to conduct the data-gathering requests as it loads data quickly, as well as saves bandwidth. Okio is the I/O library COVID Essentials utilizes, as it makes it easier to access, store, and process data. The data that COVID Essentials receives from its API is in JSON format, thus the java-json library is included in order to manipulate and parse out the data, which is ultimately stylized for user readability. Moreover, Java Swing is used as the GUI API, which builds the desktop interface that the user uses to interact with the console running behind the scenes.
  
## Front End Development
  The COVID Essentials application sits on top of the IntelliJ console, but other than having to launch the program from the IDE, the user interacts with the application through the GUI developed using the Java Swing toolkit. Upon launching, the JOptionPane presented on the desktop contains JTextFields which are responsible for receiving text input from the user—specifically input used for the <i>term</i>, <i>location</i>, and <i>limit</i> arguments. As for the <i>price</i> argument, the user interacts with a panel of mutually exclusive radio buttons that are responsible for receiving the price-point preference of the user. Much like on the Yelp website and application, price-point is determined on a scale of {$, $$, $$$, $$$$}, which translates roughly to inexpensive, moderately inexpensive, moderately expensive, and expensive respectively. It should be noted that a user can freely input any string of text into the JTextField for search, thus there is no failsafe in case users input nonsensical search parameters. Once the arguments are collected from the user, the inputs are tokenized and passed onto the HTTP builder, which leads us back to the back-end of COVID Essentials’ development.
  
  ### User Interface
  The image below displays the JOptionPane responsible for containing JTextFields belonging to the <i>term</i>, <i>location</i>, and limit arguments, as well as the <i>price</i> radio button panel. The image featured on the left-side of the JOptionPane proudly displays our COVID Essentials logo.<br>
<img src="../master/demo/ui1.png" width="400" alt="ui1">
<br>  The image below shows the output results for the client searching for sushi restaurants located in Las Vegas, with moderately expensive price preference, and search limited to the top 5 businesses in the desired area.<br>
<p align="center">
  <img src="../master/demo/ui2.png" width="400" alt="ui2">
</p>
  
