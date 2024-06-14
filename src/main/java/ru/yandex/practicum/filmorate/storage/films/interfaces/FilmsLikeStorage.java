package ru.yandex.practicum.filmorate.storage.films.interfaces;

public interface FilmsLikeStorage {

    void addLike(int filmId, int userId);

    void removeLike(int filmId, int userId);
}
