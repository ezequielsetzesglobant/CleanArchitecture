package com.example.data.database.entity

import com.example.domain.utils.ConstantUtils
import io.realm.RealmList
import io.realm.RealmObject
import java.util.Date

open class CharacterEntity(
    var id: Int = ConstantUtils.INT_DEFAULT,
    var name: String = ConstantUtils.STRING_DEFAULT,
    var description: String = ConstantUtils.STRING_DEFAULT,
    var modified: Date = Date(),
    var resourceURI: String = ConstantUtils.STRING_DEFAULT,
    var urls: RealmList<UrlEntity> = RealmList(),
    var thumbnail: ImageEntity? = ImageEntity(),
    var comics: ComicListEntity? = ComicListEntity(),
    var stories: StoryListEntity? = StoryListEntity(),
    var events: EventListEntity? = EventListEntity(),
    var series: SeriesListEntity? = SeriesListEntity(),
) : RealmObject()
