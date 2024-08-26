// Install in terminal npm install
// Install in terminal npm i axios
// Open: https://cors-anywhere.herokuapp.com/corsdemo - Select 'Request temporary access to the demo server'

import axios from 'axios';

export default{

  // getGreen Function That Makes a GET Request Using API Key to Yelp Fusion API Using User Input locationID + Dispensary, Radius, Sort By Distance Parameters
  getGreen(locationID) {
    
    let queryURL = "https://api.yelp.com/v3/businesses/search?location="+locationID+"&categories=cannabis&categories=cannabisdispensaries&categories=dispensary&radius=40000&sort_by=distance";
    const apiKey = "_VJj6fsEV44UAy-Cr65nlJl3GVdKOgK-vjlwwC7Nd6mxMJdt3rVRPGrJ8ZerjT-M7NseO0eyVDRSl2ZrOn2Ck6A8BZmdOUX0svKN-3cQfKt_dtgBaPpLk-RNfoGiZnYx";
    
    return axios.get(queryURL, {
      headers: {
        Authorization: `Bearer ${apiKey}`
      }
    })
  },

  //                                        <<<<<<<<<<<< ACTIVELY WORKING ON >>>>>>>>>>>>>>
  // getFeatured Function That Makes a GET Request Using API Key to Yelp Fusion API For The All Around Top Rated Dispensary
  getFeatured(state) {
    let queryURL = "https://api.yelp.com/v3/businesses/search?location="+state+"&categories=cannabis&categories=cannabisdispensaries&categories=dispensary&sort_by=rating&limit=1";
    const apiKey = "_VJj6fsEV44UAy-Cr65nlJl3GVdKOgK-vjlwwC7Nd6mxMJdt3rVRPGrJ8ZerjT-M7NseO0eyVDRSl2ZrOn2Ck6A8BZmdOUX0svKN-3cQfKt_dtgBaPpLk-RNfoGiZnYx";

    return axios.get(queryURL, {
      headers: {
        Authorization: `Bearer ${apiKey}`
      }
    })
  }
};
