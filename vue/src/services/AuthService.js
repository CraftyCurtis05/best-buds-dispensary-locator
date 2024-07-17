import axios from 'axios';

//Use user information to interact with backend
export default {
  login(user) {
    return axios.post('/login', user)
  },
  register(user) {
    return axios.post('/register', user)
  }
};