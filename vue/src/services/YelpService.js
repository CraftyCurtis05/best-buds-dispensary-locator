// Install in terminal npm install
// Install in terminal npm i axios
// Open: https://cors-anywhere.herokuapp.com/corsdemo
// npm run dev

import axios from 'axios';

export default{

  //Get green function using location Id that connects to Yelp API using bearer token for authorization
  getGreen(locationID) {
    let queryURL = "https://cors-anywhere.herokuapp.com/https://api.yelp.com/v3/businesses/search?location="+locationID+"&term=dispensary&radius=20000&sort_by=distance&limit=20";
    const apiKey = "_VJj6fsEV44UAy-Cr65nlJl3GVdKOgK-vjlwwC7Nd6mxMJdt3rVRPGrJ8ZerjT-M7NseO0eyVDRSl2ZrOn2Ck6A8BZmdOUX0svKN-3cQfKt_dtgBaPpLk-RNfoGiZnYx";
    
    return axios.get(queryURL, {
      headers: {
        Authorization: `Bearer ${apiKey}`
      }
    })
  }
}