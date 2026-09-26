import axios from "axios";

export default {

    // Record an activity completed by the authenticated user
    createUserActivity(
        activityType,
        activityValue = null
    ) {

        return axios.post(
            "/api/activities",
            {
                activityType,
                activityValue
            }
        );

    }

};