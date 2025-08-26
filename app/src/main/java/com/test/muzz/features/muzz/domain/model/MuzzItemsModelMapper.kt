package com.test.muzz.features.muzz.domain.model

import com.test.muzz.features.muzz.data.model.MuzzWithImages
import javax.inject.Inject

class MuzzItemsModelMapper
@Inject
constructor() {
    fun map(muzzItems: List<MuzzWithImages>) = mutableListOf<MuzzModel>()
        .apply {
            muzzItems.forEach { add(mapMuzzItem(it)) }
        }.toList()

    private fun mapMuzzItem(item: MuzzWithImages) = when (item.muzz.type) {
        "slider" ->
            MuzzModel.Slider(
                item.images.mapNotNull { it.url },
                item.muzz.datatype,
                item.muzz.title,
                item.muzz.author,
                item.muzz.sourceName,
                item.muzz.deepLink,
                item.muzz.url,
                item.muzz.publishedAt,
                item.muzz.content,
                item.muzz.description,
            )

        "image" ->
            MuzzModel.Image(
                item.images.mapNotNull { it.url },
                item.muzz.datatype,
                item.muzz.title,
                item.muzz.author,
                item.muzz.sourceName,
                item.muzz.deepLink,
                item.muzz.url,
                item.muzz.publishedAt,
                item.muzz.content,
                item.muzz.description,
            )

        else -> MuzzModel.Empty()
    }
}
