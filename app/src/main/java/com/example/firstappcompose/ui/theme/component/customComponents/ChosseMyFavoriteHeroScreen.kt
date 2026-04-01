package com.example.firstappcompose.ui.theme.component.customComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstappcompose.R
import com.example.firstappcompose.ui.model.Hero
import com.example.firstappcompose.ui.theme.FirstAppComposeTheme

@Composable
fun ChooseMyFavoriteHero(modifier: Modifier = Modifier) {
    val heroSelectIndex = rememberSaveable { mutableIntStateOf(-1) }

    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.qual_seu_heroi_favorito),
            style = MaterialTheme.typography.headlineMedium
        )

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 16.dp)
        )

        ChoseHeroList(
            heroSelectIndex = heroSelectIndex.intValue, heroes = createHeroList(), onSelectedHero = {
                selectedHero, index ->
                heroSelectIndex.intValue = index
            // aplica lógica de seleção
        })
    }
}


@Composable
fun ChoseHeroList(
    modifier: Modifier = Modifier,
    heroes: List<Hero>, heroSelectIndex: Int,
    onSelectedHero: (selectedHero: Hero, index: Int) -> Unit)
{
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(
            items = heroes,
            key = { _, hero -> hero.hashCode() }
        ) { index, hero ->
            HeroCard(
                hero = hero,
                isSelected = heroSelectIndex == index,
                onClick = {
                    onSelectedHero(hero, index)
                })
        }
    }
}

@Composable
fun HeroCard(modifier: Modifier = Modifier, hero: Hero, isSelected: Boolean, onClick: () -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(
                selected = isSelected,
                colors = RadioButtonDefaults.colors(selectedColor = Color.Red),
                onClick = onClick
            )
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .size(66.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                painter = painterResource(hero.image),
                contentDescription = hero.name,
            )
            Column {
                Text(
                    style = MaterialTheme.typography.titleLarge, text = hero.name
                )
                Text(
                    style = MaterialTheme.typography.bodySmall, text = hero.description
                )
            }
        }
    }
}

@Composable
fun createHeroList(): List<Hero> {
    val heroesNames = stringArrayResource(R.array.hero_names)
    val heroesDescriptions = stringArrayResource(R.array.hero_descriptions)
    val heroImages = listOf(
        R.drawable.ic_captain_america,
        R.drawable.ic_hulk,
        R.drawable.ic_black_panther,
        R.drawable.ic_spider_man,
        R.drawable.ic_iron_man
    )

    return heroesNames.zip(heroesDescriptions).zip(heroImages) { (name, description), imageRes ->
        Hero(name = name, description = description, image = imageRes)
    }
}

@Preview
@Composable
private fun HeroCardPreview() {
    FirstAppComposeTheme {
        HeroCard(
            hero = createHeroList()[0], isSelected = true, onClick = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun ChooseMyFavoriteHeroPreview() {
    FirstAppComposeTheme {
        ChooseMyFavoriteHero(
            modifier = Modifier.fillMaxSize()
        )
    }
}