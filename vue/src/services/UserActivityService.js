import axios from "axios";

export default {

    // Record an activity completed by the authenticated user
    createUserActivity(
        activityType,
        activityValue
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