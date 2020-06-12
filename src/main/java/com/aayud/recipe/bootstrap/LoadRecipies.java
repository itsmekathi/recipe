package com.aayud.recipe.bootstrap;

import com.aayud.recipe.domain.*;
import com.aayud.recipe.repositories.CategoryRepository;
import com.aayud.recipe.repositories.RecipeRepository;
import com.aayud.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@Component
public class LoadRecipies implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public LoadRecipies(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("In bootstrap class");
        Recipe perfectGuacamole = constructPerfectGuacamole();
        Recipe spicyGrilledChickenTacos = constructSpicyGrilledChicken();

        recipeRepository.save(perfectGuacamole);
        recipeRepository.save(spicyGrilledChickenTacos);
    }

    private Recipe constructSpicyGrilledChicken(){
        Recipe spicyGrilledChicken = new Recipe();
        Category category_mexican = categoryRepository.findByDescription("Mexican").get();
        Category category_american = categoryRepository.findByDescription("American").get();

        UnitOfMeasure uomTeaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure uomTablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure uomCup = unitOfMeasureRepository.findByDescription("Cup").get();
        UnitOfMeasure uomEaches = unitOfMeasureRepository.findByDescription("Eaches").get();
        UnitOfMeasure uomPounds = unitOfMeasureRepository.findByDescription("Pounds").get();
        UnitOfMeasure uomOunces  = unitOfMeasureRepository.findByDescription("Ounces").get();

        spicyGrilledChicken.setDescription("Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes.");
        spicyGrilledChicken.getCategories().add(category_american);
        spicyGrilledChicken.getCategories().add(category_mexican);
        spicyGrilledChicken.setPrepTime(20);
        spicyGrilledChicken.setCookTime(15);
        spicyGrilledChicken.setServings(6);
        spicyGrilledChicken.setSource("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        spicyGrilledChicken.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        spicyGrilledChicken.setDirections(
                " In a large bowl, stir together the chili powder, oregano, cumin," +
                        " sugar, salt, garlic and orange zest. Stir in the orange juice " +
                        "and olive oil to make a loose paste. Add the chicken to the bowl" +
                        " and toss to coat all over.Set aside to marinate while the grill " +
                        "heats and you prepare the rest of the toppings. Grill the chicken " +
                        "for 3 to 4 minutes per side, or until a thermometer inserted into the " +
                        "thickest part of the meat registers 165F. Transfer to a plate and rest " +
                        "for 5 minutes. Place each tortilla on the grill or on a hot, dry skillet " +
                        "over medium-high heat. As soon as you see pockets of the air start to puff " +
                        "up in the tortilla, turn it with tongs and heat for a few seconds on the " +
                        "other side. Wrap warmed tortillas in a tea towel to keep them warm until " +
                        "serving. Slice the chicken into strips. On each tortilla, place a small" +
                        " handful of arugula. Top with chicken slices, sliced avocado, radishes, " +
                        "tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with" +
                        " lime wedges.");

        spicyGrilledChicken.addIngredient( new Ingredient("Dried oregano",new BigDecimal(2),uomTablespoon));
        spicyGrilledChicken.addIngredient(new Ingredient("Dried cumin",new BigDecimal(1), uomTeaspoon));
        spicyGrilledChicken.addIngredient(new Ingredient("Sugar",new BigDecimal(1), uomTeaspoon));
        spicyGrilledChicken.addIngredient(new Ingredient("Salt", new BigDecimal(0.5), uomTeaspoon));
        spicyGrilledChicken.addIngredient(new Ingredient("Garlic", new BigDecimal(1), uomEaches));
        spicyGrilledChicken.addIngredient(new Ingredient("Finely grated orange zest",new BigDecimal(1), uomTablespoon));
        spicyGrilledChicken.addIngredient(new Ingredient("Fresh squeezed orange juice",new BigDecimal(3), uomTablespoon));
        spicyGrilledChicken.addIngredient(new Ingredient("Olive oil",new BigDecimal(2), uomEaches));
        spicyGrilledChicken.addIngredient(new Ingredient("Boneless Chicken thighs", new BigDecimal(1.25), uomPounds));
        spicyGrilledChicken.addIngredient(new Ingredient("Small corn tortillas",new BigDecimal(8), uomEaches));
        spicyGrilledChicken.addIngredient(new Ingredient("Packed baby arugula",new BigDecimal(3), uomOunces));
        spicyGrilledChicken.addIngredient(new Ingredient("Ripe avocados",new BigDecimal(2), uomEaches));
        spicyGrilledChicken.addIngredient(new Ingredient("Radishes",new BigDecimal(4), uomEaches));
        spicyGrilledChicken.addIngredient(new Ingredient("Cherry tomatoes",new BigDecimal(0.5), uomPounds));
        spicyGrilledChicken.addIngredient(new Ingredient("Red Onion",new BigDecimal(0.25), uomEaches));
        spicyGrilledChicken.addIngredient(new Ingredient("Cilantro",new BigDecimal(1), uomEaches));
        spicyGrilledChicken.addIngredient(new Ingredient("Sour cream",new BigDecimal(0.5), uomCup));
        spicyGrilledChicken.addIngredient(new Ingredient("Lime",new BigDecimal(1), uomEaches));

        Notes spicyGrilledNotes = new Notes();
        spicyGrilledChicken.setDescription("Any and every kind of leftover can go inside a warm tortilla, " +
                "usually with a healthy dose of pickled jalapenos. ");
        spicyGrilledChicken.setNotes(spicyGrilledNotes);
        return spicyGrilledChicken;
    }

    private Recipe constructPerfectGuacamole() {
        Recipe perfectGuacamole = new Recipe();
        Category category_american = categoryRepository.findByDescription("American").get();
        UnitOfMeasure uomTeaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure uomTablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure uomEaches = unitOfMeasureRepository.findByDescription("Eaches").get();
        UnitOfMeasure uomDash = unitOfMeasureRepository.findByDescription("Dash").get();

        perfectGuacamole.setDescription("How to Make Perfect Guacamole");
        perfectGuacamole.getCategories().add(category_american);
        perfectGuacamole.setPrepTime(10);
        perfectGuacamole.setCookTime(10);
        perfectGuacamole.setServings(4);
        perfectGuacamole.setSource("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        perfectGuacamole.setDirections(
                "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon." +
                        "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                        "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown." +
                        "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness." +
                        "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste." +
                        "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving." +
                        "Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)" +
                        " Refrigerate until ready to serve.");
        perfectGuacamole.addIngredient(new Ingredient("Ripe avocados",new BigDecimal(2), uomEaches));
        perfectGuacamole.addIngredient(new Ingredient("Salt",new BigDecimal(0.25), uomTeaspoon));
        perfectGuacamole.addIngredient(new Ingredient("Lemon juice",new BigDecimal(1), uomTablespoon));
        perfectGuacamole.addIngredient(new Ingredient("Serrano chiles",new BigDecimal(2), uomEaches));
        perfectGuacamole.addIngredient(new Ingredient("Cilantro leaves",new BigDecimal(2), uomTablespoon));
        perfectGuacamole.addIngredient(new Ingredient("Freshly grated black pepper",new BigDecimal(1), uomDash));
        perfectGuacamole.addIngredient(new Ingredient("Ripe tomato, seeds and pulp removed, chopped",new BigDecimal(0.5), uomEaches));
        perfectGuacamole.addIngredient(new Ingredient("Red radishes",new BigDecimal(1), uomEaches));
        perfectGuacamole.addIngredient(new Ingredient("Tortilla chips, to serve",new BigDecimal(1), uomEaches));
        Notes perfectGuacamoleNotes = new Notes();
        perfectGuacamoleNotes.setDescription("Guacamole is best eaten right after it’s made. Like apples, avocados start to oxidize and turn brown once they’ve been cut.");
        perfectGuacamole.setNotes(perfectGuacamoleNotes);
        return perfectGuacamole;
    }


}
