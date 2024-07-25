import axios from 'axios';

//Use user favorite information to interact with backend
export default {

    makeFavorite(favorite) {
        return axios.post('/favorite', favorite)
    },
    
    getFavorite(favorite) {
        return axios.get('/favorite', favorite)
    }
}