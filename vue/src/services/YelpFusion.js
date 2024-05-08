// Install in terminal npm install
// Install in terminal npm i axios
// Open: https://cors-anywhere.herokuapp.com/corsdemo
// npm run dev

import axios from 'axios';

export default{
  getBuzzed(locationID){
    let queryURL = "https://cors-anywhere.herokuapp.com/https://api.yelp.com/v3/businesses/search?location="+locationID+"&term=dispensary&radius=40000&sort_by=distance&limit=20";
    const apiKey = "fliIPFHrHNmWhDWgrkEyrs6ilrEBipZbZs4ng-CkDBBmrEJeYiaP_uFxdeP7gVLxucX8ExsFYuqgsmiRPFuIpheFSyRfrZgKPgVRmhf9vnoVXkCs-deEgEEsDf87ZnYx"; 
    
    return axios.get(queryURL, {
    
      headers: {
        Authorization: `Bearer ${apiKey}`
      }
    })
  }


// const options = {method: 'GET', headers: {accept: 'application/json'}};

// fetch('https://api.yelp.com/v3/businesses/search?sort_by=best_match&limit=20', options)
//   .then(response => response.json())
//   .then(response => console.log(response))
//   .catch(err => console.error(err));