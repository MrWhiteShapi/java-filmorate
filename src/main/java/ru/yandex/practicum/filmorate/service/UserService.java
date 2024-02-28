package ru.yandex.practicum.filmorate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.ElementNotFoundException;
import ru.yandex.practicum.filmorate.exception.UserFriendException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.storage.InMemoryUserStorage;
import ru.yandex.practicum.filmorate.storage.UserStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    private final UserStorage userStorage;

    @Autowired //если одна переменная для внедрения зависимости не легче ли просто к переменной поставить аннотацию?
    public UserService(InMemoryUserStorage userStorage) {
        this.userStorage = userStorage;
    }

    /**
     * the method responsible for the logic of adding another user to friends by the user
     *
     * @param userId   of the user of the subject
     * @param friendId of the user of the object
     * @return user who has just benn added to friends list
     * @throws UserFriendException
     * @throws ElementNotFoundException
     */
    public User addFriend(Integer userId, Integer friendId) throws UserFriendException, ElementNotFoundException {
        User user = userStorage.getUserById(userId);
        User friend = userStorage.getUserById(friendId);
        checkIfUserNotExist(user);
        checkIfUserNotExist(friend);
        if (user.getFriends().contains(friendId)) {
            log.error(String.format("client cannot add the %s user to the friends list again", friend.getName()));
            throw new UserFriendException(String.format("User with %d id is already your friend", friendId));
        }
        user.getFriends().add(friendId);
        friend.getFriends().add(userId);
        log.error(String.format("client has just added the %s user as a friend", friend.getName()));
        return friend;
    }

    /**
     * the method responsible for the logic of removing another user to friends by the user
     *
     * @param userId   of the user of the subject
     * @param friendId of the user of the object
     * @return user who has just been removed from fiends list
     * @throws UserFriendException
     * @throws ElementNotFoundException
     */
    public User removeFriend(Integer userId, Integer friendId) throws UserFriendException, ElementNotFoundException {
        User user = userStorage.getUserById(userId);
        User friend = userStorage.getUserById(friendId);
        checkIfUserNotExist(user);
        checkIfUserNotExist(friend);
        if (!user.getFriends().contains(friendId)) {
            log.error(String.format("client cannot remove the %s user who is not his friend from the friends list", friend.getName()));
            throw new UserFriendException(String.format("User with %d id is not your friend", friendId));
        }
        user.getFriends().remove(friendId);
        friend.getFriends().remove(userId);
        log.info(String.format("client has just removed the %s user", friend.getName()));
        return friend;
    }

    /**
     * @param id of the user of the subject
     * @return the list of user's friends
     * @throws ElementNotFoundException
     */
    public List<User> getListOfFriends(Integer id) throws ElementNotFoundException {
        User user = userStorage.getUserById(id);
        checkIfUserNotExist(user);
        log.info("client has just got the list of his friends");
        return user.getFriends().stream().map(userStorage::getUserById).collect(Collectors.toList());
    }

    /**
     * @param id       of the user of the subject
     * @param friendId of the user of the object
     * @throws ElementNotFoundException
     */
    public User getFriendById(Integer id, Integer friendId) throws ElementNotFoundException {
        User user = userStorage.getUserById(id);
        checkIfUserNotExist(user);
        log.info("client has just got a friend");
        return userStorage.getUserById(user.getFriends().get(friendId));
    }

    /**
     * the method responsible for the logic of getCommonsFriends endpoint
     *
     * @param id      of the user of the subject
     * @param otherId of the user of the object
     * @throws ElementNotFoundException
     */
    public List<User> getListOfCommonsFriends(Integer id, Integer otherId) throws ElementNotFoundException {
        User user = userStorage.getUserById(id);
        User friend = userStorage.getUserById(otherId);
        checkIfUserNotExist(user);
        checkIfUserNotExist(friend);
        if (!user.getFriends().isEmpty() && !friend.getFriends().isEmpty()) {
            log.info(String.format("client has just got the list of common friends with the %s user", friend.getName()));
            return userStorage.getUsers().stream()
                    .filter(user1 -> (user1.getFriends().contains(user.getId()) && user1.getFriends().contains(friend.getId())) &&
                            (!user1.equals(user.getId()) && !user1.equals(friend.getId()))).collect(Collectors.toList());
        } else {
            return new ArrayList<User>();
        }

    }

    public User getUserById(Integer id) throws ElementNotFoundException {
        checkIfUserNotExist(userStorage.getUserById(id));
        return userStorage.getUserById(id);

    }

    public User addUser(User user) throws ValidationException {
        return userStorage.addUser(user);
    }

    public User updateUser(User user) throws ValidationException {
        return userStorage.updateUser(user);
    }

    public User removeUser(Integer id) throws ElementNotFoundException {
        checkIfUserNotExist(userStorage.getUserById(id));
        return userStorage.deleteUserById(id);
    }

    public List<User> getUsers() {
        return userStorage.getUsers();
    }

    public void checkIfUserNotExist(User user) throws ElementNotFoundException {
        if (user == null) {
            log.error("this user is not exist to return, probably the path variables incorrect");
            throw new ElementNotFoundException("the user is not exist");
        }
    }

}
