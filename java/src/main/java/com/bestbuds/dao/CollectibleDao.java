package com.bestbuds.dao;

import com.bestbuds.model.Collectible;
import com.bestbuds.model.UserCollectible;

import java.util.List;

public interface CollectibleDao {

    Collectible getCollectibleByCode(
            String code
    );

    List<UserCollectible> getUserCollectibles(
            int userId
    );

    UserCollectible getUserCollectible(
            int userId,
            String code
    );

    UserCollectible unlockCollectible(
            int userId,
            String code
    );
}