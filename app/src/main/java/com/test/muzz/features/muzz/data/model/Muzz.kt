package com.test.muzz.features.muzz.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "muzz")
data class Muzz(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val datatype: String?,
    val title: String?,
    val author: String?,
    @ColumnInfo(name = "source_name") val sourceName: String?,
    @ColumnInfo(name = "deep_link") val deepLink: String?,
    val url: String?,
    val publishedAt: String?,
    val content: String?,
    val description: String?,
    val type: String?,
)

@Entity(
    tableName = "images",
    foreignKeys = [
        ForeignKey(
            entity = Muzz::class,
            parentColumns = ["id"],
            childColumns = ["muzz_id"],
        ),
    ],
    indices = [Index(value = ["muzz_id"])],
)
data class Image(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "muzz_id") val muzzId: Int,
    val url: String?,
)

data class MuzzWithImages(
    @Embedded val muzz: Muzz,
    @Relation(
        parentColumn = "id",
        entityColumn = "muzz_id",
    )
    val images: List<Image>,
)
