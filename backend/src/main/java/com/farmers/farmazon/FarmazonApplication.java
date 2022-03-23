package com.farmers.farmazon;

import com.farmers.farmazon.Models.Cart;
import com.farmers.farmazon.Models.Product;
import com.farmers.farmazon.Models.ProductLine;
import com.farmers.farmazon.Models.User;
import com.farmers.farmazon.Repos.CartRepo;
import com.farmers.farmazon.Repos.ProductLineRepo;
import com.farmers.farmazon.Repos.ProductRepo;
import com.farmers.farmazon.Repos.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FarmazonApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmazonApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner (UserRepo userRepo, CartRepo cartRepo, ProductLineRepo productLineRepo, ProductRepo productRepo) {

		return args -> {

			Product cow = new Product();
			cow.setName("Cow");
			cow.setDescription("Goes moo");
			cow.setEmoji("&#128046;");
			cow.setPrice(5);
			cow.setRegion("field");
			cow.setCompany("Bovine R us");
			cow.setRating(7);
			Product savedCow = productRepo.save(cow);

			Product goat = new Product();
			goat.setName("Goat");
			goat.setDescription("OK but does anyone REALLY like goats cheese??");
			goat.setEmoji("&#128016;");
			goat.setPrice(6);
			goat.setRegion("field");
			goat.setCompany("Goatye");
			goat.setRating(2);
			Product savedGoat = productRepo.save(goat);

			Product rabbit = new Product();
			rabbit.setName("Rabbit");
			rabbit.setDescription("These guys breed like, well, rabbits...");
			rabbit.setEmoji("&#128007;");
			rabbit.setPrice(8);
			rabbit.setRegion("field");
			rabbit.setCompany("Watership Downpayment");
			rabbit.setRating(6);
			Product savedRabbit = productRepo.save(rabbit);

			Product sheep = new Product();
			sheep.setName("Sheep");
			sheep.setDescription("So cuddly! But otherwise pretty dull");
			sheep.setEmoji("&#128017;");
			sheep.setPrice(4);
			sheep.setRegion("field");
			sheep.setCompany("Woolworths (I had to)");
			sheep.setRating(3);
			Product savedSheep = productRepo.save(sheep);

			Product pig = new Product();
			pig.setName("Pig");
			pig.setDescription("Can't sweat so rolls in mud!");
			pig.setEmoji("&#128022;");
			pig.setPrice(8);
			pig.setRegion("field");
			pig.setCompany("Jurassic Pork");
			pig.setRating(3);
			Product savedPig = productRepo.save(pig);

			Product monkey = new Product();
			monkey.setName("Monkey");
			monkey.setDescription("He's a cheeky one");
			monkey.setEmoji("&#128018;");
			monkey.setPrice(30);
			monkey.setRegion("field");
			monkey.setCompany("Monkeyville");
			monkey.setRating(7);
			Product savedMonkey = productRepo.save(monkey);

			Product horse = new Product();
			horse.setName("Horse");
			horse.setDescription("Always the mane character");
			horse.setEmoji("&#128014;");
			horse.setPrice(15);
			horse.setRegion("field");
			horse.setCompany("Horses for Courses");
			horse.setRating(6);
			Product savedHorse = productRepo.save(horse);

			Product scorpion = new Product();
			scorpion.setName("Scorpion");
			scorpion.setDescription("Guess his starsign");
			scorpion.setEmoji("&#129410;");
			scorpion.setPrice(8);
			scorpion.setRegion("desert");
			scorpion.setCompany("Sting!");
			scorpion.setRating(3);
			Product savedScorpion = productRepo.save(scorpion);

			Product lizard = new Product();
			lizard.setName("Lizard");
			lizard.setDescription("Cold blooded. Doesn't care about your feelings.");
			lizard.setEmoji("&#129422;");
			lizard.setPrice(8);
			lizard.setRegion("desert");
			lizard.setCompany("Not dragons but still pretty cool");
			lizard.setRating(6);
			Product savedLizard = productRepo.save(lizard);

			Product eagle = new Product();
			eagle.setName("Eagle");
			eagle.setDescription("Animal of the free baby");
			eagle.setEmoji("&#129413;");
			eagle.setPrice(15);
			eagle.setRegion("air");
			eagle.setCompany("Stars 'n Stripes");
			eagle.setRating(6);
			Product savedEagle = productRepo.save(eagle);

			Product owl = new Product();
			owl.setName("Owl");
			owl.setDescription("Wise old owl");
			owl.setEmoji("&#129417;");
			owl.setPrice(12);
			owl.setRegion("air");
			owl.setCompany("Twit-twoo org");
			owl.setRating(8);
			Product savedOwl = productRepo.save(owl);

			Product parrot = new Product();
			parrot.setName("Parrot");
			parrot.setDescription("No, Polly does not want a cracker");
			parrot.setEmoji("&#129436;");
			parrot.setPrice(25);
			parrot.setRegion("air");
			parrot.setCompany("Colour Corp (TM)");
			parrot.setRating(6);
			Product savedParrot = productRepo.save(parrot);

			Product dolphin = new Product();
			dolphin.setName("Dolphin");
			dolphin.setDescription("Can use echo location to find their way home");
			dolphin.setEmoji("&#128044;");
			dolphin.setPrice(30);
			dolphin.setRegion("water");
			dolphin.setCompany("Flipperoo");
			dolphin.setRating(7);
			Product savedDolphin = productRepo.save(dolphin);

			Product frog = new Product();
			frog.setName("Frog");
			frog.setDescription("Just chilling on his lily pad");
			frog.setEmoji("&#128056;");
			frog.setPrice(10);
			frog.setRegion("water");
			frog.setCompany("Frogwarts");
			frog.setRating(8);
			Product savedFrog = productRepo.save(frog);

			Product whale = new Product();
			whale.setName("Whale");
			whale.setDescription("AHWWWOOOOOOOWWWWOOOOEEEEE - Direct quote");
			whale.setEmoji("&#128051;");
			whale.setPrice(60);
			whale.setRegion("water");
			whale.setCompany("Whale be there for you");
			whale.setRating(8);
			Product savedWhale = productRepo.save(whale);

			Product fish = new Product();
			fish.setName("Fish");
			fish.setDescription("Would rather not go with chips");
			fish.setEmoji("&#128032;");
			fish.setPrice(7);
			fish.setRegion("water");
			fish.setCompany("Selling Nemo");
			fish.setRating(4);
			Product savedFish = productRepo.save(fish);

			Product shark = new Product();
			shark.setName("Shark");
			shark.setDescription("Duuuuun dun...duuuuuuuuuun DUN!");
			shark.setEmoji("&#129416;");
			shark.setPrice(32);
			shark.setRegion("water");
			shark.setCompany("Jawsco");
			shark.setRating(6);
			Product savedShark = productRepo.save(shark);

			Product bee = new Product();
			bee.setName("Bee");
			bee.setDescription("Busy little guy buzz buzz");
			bee.setEmoji("&#128029;");
			bee.setPrice(9);
			bee.setRegion("air");
			bee.setCompany("Hun-E");
			bee.setRating(8);
			Product savedBee = productRepo.save(bee);

			Product bear = new Product();
			bear.setName("Bear");
			bear.setDescription("Cute but dangerous!");
			bear.setEmoji("&#129528;");
			bear.setPrice(17);
			bear.setRegion("field");
			bear.setCompany("Winnie's");
			bear.setRating(3);
			Product savedBear = productRepo.save(bear);

			Product panda = new Product();
			panda.setName("Panda");
			panda.setDescription("Adorable but inept");
			panda.setEmoji("&#128060;");
			panda.setPrice(21);
			panda.setRegion("field");
			panda.setCompany("WWF");
			panda.setRating(8);
			Product savedPanda = productRepo.save(panda);

			Product otter = new Product();
			otter.setName("Otter");
			otter.setDescription("Collects their favourite pebbles (seriously)");
			otter.setEmoji("&#129446;");
			otter.setPrice(13);
			otter.setRegion("water");
			otter.setCompany("What's the motter?");
			otter.setRating(7);
			Product savedOtter = productRepo.save(otter);

			Product penguin = new Product();
			penguin.setName("Penguin");
			penguin.setDescription("Might be a bit lost...");
			penguin.setEmoji("&#128039;");
			penguin.setPrice(25);
			penguin.setRegion("water");
			penguin.setCompany("ice ** 3");
			penguin.setRating(9);
			Product savedPenguin = productRepo.save(penguin);

			Product bird = new Product();
			bird.setName("Bird");
			bird.setDescription("Winging it");
			bird.setEmoji("&#128038;");
			bird.setPrice(6);
			bird.setRegion("air");
			bird.setCompany("Birds n Bees Co.");
			bird.setRating(3);
			Product savedBird = productRepo.save(bird);

			Product camel = new Product();
			camel.setName("Camel");
			camel.setDescription("One bumpy boy");
			camel.setEmoji("&#128043;");
			camel.setPrice(17);
			camel.setRegion("desert");
			camel.setCompany("The Camel Company (We only sell camels!)");
			camel.setRating(9);
			Product savedCamel = productRepo.save(camel);

			Product peacock = new Product();
			peacock.setName("Peacock");
			peacock.setDescription("Always dressed to impress");
			peacock.setEmoji("&#129434;");
			peacock.setPrice(14);
			peacock.setRegion("field");
			peacock.setCompany("Peacocks 4 u");
			peacock.setRating(9);
			Product savedPeacock = productRepo.save(peacock);

			Product turtle = new Product();
			turtle.setName("Turtle");
			turtle.setDescription("Not to be confused with his brother Tortoise");
			turtle.setEmoji("&#128034;");
			turtle.setPrice(15);
			turtle.setRegion("water");
			turtle.setCompany("To shell and back");
			turtle.setRating(6);
			Product savedTurtle = productRepo.save(turtle);

			Product deer = new Product();
			deer.setName("Deer");
			deer.setDescription("His antlers are magnificent");
			deer.setEmoji("&#129420;");
			deer.setPrice(22);
			deer.setRegion("field");
			deer.setCompany("Oh deer");
			deer.setRating(5);
			Product savedDeer = productRepo.save(deer);

			Product snake = new Product();
			snake.setName("Snake");
			snake.setDescription("I'm a slithery snaaaaaake");
			snake.setEmoji("&#128013;");
			snake.setPrice(14);
			snake.setRegion("desert");
			snake.setCompany("Scale Mail");
			snake.setRating(6);
			Product savedSnake = productRepo.save(snake);

			Product swan = new Product();
			swan.setName("Swan");
			swan.setDescription("Has a beautiful once in a lifetime song");
			swan.setEmoji("&#129442;");
			swan.setPrice(20);
			swan.setRegion("water");
			swan.setCompany("Ron SwanSong");
			swan.setRating(7);
			Product savedSwan = productRepo.save(swan);

			Product zebra = new Product();
			zebra.setName("Zebra");
			zebra.setDescription("Just a mean horse basically");
			zebra.setEmoji("&#129427;");
			zebra.setPrice(20);
			zebra.setRegion("field");
			zebra.setCompany("Stripes");
			zebra.setRating(5);
			Product savedZebra = productRepo.save(zebra);

			Product dog = new Product();
			dog.setName("Dog");
			dog.setDescription("Woof Woof!");
			dog.setEmoji("&#128021;");
			dog.setPrice(34);
			dog.setRegion("field");
			dog.setCompany("Barklays");
			dog.setRating(8);
			Product savedDog = productRepo.save(dog);

			Product cat = new Product();
			cat.setName("Cat");
			cat.setDescription("Not a dog, but still cute :)");
			cat.setEmoji("&#128049;");
			cat.setPrice(20);
			cat.setRegion("field");
			cat.setCompany("Feline good");
			cat.setRating(7);
			Product savedCat = productRepo.save(cat);

			Product bat = new Product();
			bat.setName("Bat");
			bat.setDescription("Not just for halloween");
			bat.setEmoji("&#129415;");
			bat.setPrice(16);
			bat.setRegion("air");
			bat.setCompany("Wayne Corp");
			bat.setRating(4);
			Product savedBat = productRepo.save(bat);


			Product mouse = new Product();
			mouse.setName("Mouse");
			mouse.setDescription("Mice don't actually like cheese!");
			mouse.setEmoji("&#128045;");
			mouse.setPrice(4);
			mouse.setRegion("field");
			mouse.setCompany("Mice to meet you");
			mouse.setRating(6);
			Product savedMouse = productRepo.save(mouse);


			Product giraffe = new Product();
			giraffe.setName("giraffe");
			giraffe.setDescription("Never lies about their height");
			giraffe.setEmoji("&#129426;");
			giraffe.setPrice(35);
			giraffe.setRegion("desert");
			giraffe.setCompany("Giraffein me on");
			giraffe.setRating(6);
			Product savedGiraffe = productRepo.save(giraffe);

			Product lion = new Product();
			lion.setName("Lion");
			lion.setDescription("The ciiiiiircle of liiiiife");
			lion.setEmoji("&#129409;");
			lion.setPrice(40);
			lion.setRegion("desert");
			lion.setCompany("Pride Rock");
			lion.setRating(9);
			Product savedLion = productRepo.save(lion);

			Product unicorn = new Product();
			unicorn.setName("Unicorn");
			unicorn.setDescription("Sparkle magic");
			unicorn.setEmoji("&#129412;");
			unicorn.setPrice(7000);
			unicorn.setRegion("mystical");
			unicorn.setCompany("Unicorns R us");
			unicorn.setRating(9);
			Product savedUnicorn = productRepo.save(unicorn);

			Product dragon = new Product();
			dragon.setName("Dragon");
			dragon.setDescription("Here there be dragons!");
			dragon.setEmoji("&#128009;");
			dragon.setPrice(10000);
			dragon.setRegion("mystical");
			dragon.setCompany("Daenerys Dragon Shop");
			dragon.setRating(10);
			Product savedDragon = productRepo.save(dragon);

			Product sauropod = new Product();
			sauropod.setName("Sauropod");
			sauropod.setDescription("Extinct, but he doesn't know that");
			sauropod.setEmoji("&#129429;");
			sauropod.setPrice(500);
			sauropod.setRegion("mystical");
			sauropod.setCompany("Dinosaur Den");
			sauropod.setRating(10);
			Product savedSauropod = productRepo.save(sauropod);

			Product alien = new Product();
			alien.setName("Alien");
			alien.setDescription("...you're trying to BUY an alien?");
			alien.setEmoji("&#128125;");
			alien.setPrice(2000);
			alien.setRegion("mystical");
			alien.setCompany("Mars");
			alien.setRating(10);
			Product savedAlien = productRepo.save(alien);

			Product chrisProduct= new Product();
			chrisProduct.setName("Farmer Chris");
			chrisProduct.setDescription("Farmer of the Land...");
			chrisProduct.setEmoji("chris-emoji");
			chrisProduct.setPrice(100);
			chrisProduct.setRegion("field");
			chrisProduct.setCompany("Farmazon");
			chrisProduct.setRating(10);
			Product saveChris = productRepo.save(chrisProduct);

			Product parthProduct = new Product();
			parthProduct.setName("Farmer Parth");
			parthProduct.setDescription("Farmer of the Sky...");
			parthProduct.setEmoji("parth-emoji");
			parthProduct.setPrice(100);
			parthProduct.setRegion("air");
			parthProduct.setCompany("Farmazon");
			parthProduct.setRating(10);
			Product saveParth = productRepo.save(parthProduct);

			Product jackProduct = new Product();
			jackProduct.setName("Farmer Jack");
			jackProduct.setDescription("Farmer of the Sea...");
			jackProduct.setEmoji("jack-emoji");
			jackProduct.setPrice(100);
			jackProduct.setRegion("water");
			jackProduct.setCompany("Farmazon");
			jackProduct.setRating(10);
			Product saveCJack = productRepo.save(jackProduct);

			////////////////////////////////////
			// JACK START HERE

			Product gorilla = new Product();
			gorilla.setName("Gorilla");
			gorilla.setDescription("`Ooh ooh ah Tarzan my king` - I don't know I've not seen the film in ages");
			gorilla.setEmoji("&#129421;");
			gorilla.setPrice(40);
			gorilla.setRegion("field");
			gorilla.setCompany("Harambezos");
			gorilla.setRating(8);
			Product savedGorilla = productRepo.save(gorilla);

			Product orangutan = new Product();
			orangutan.setName("Orangutan");
			orangutan.setDescription("The best animal. Hands down. That's it. Go home. Discussion over. end. fin.");
			orangutan.setEmoji("&#129447;");
			orangutan.setPrice(50);
			orangutan.setRegion("field");
			orangutan.setCompany("Orange you glad you didn't buy a monkey");
			orangutan.setRating(10);
			Product savedOrangutan = productRepo.save(orangutan);

			Product wolf = new Product();
			wolf.setName("Wolf");
			wolf.setDescription("'On all levels except physical, I am a wolf'");
			wolf.setEmoji("&#128058;");
			wolf.setPrice(40);
			wolf.setRegion("field");
			wolf.setCompany("Rent-A-Grandma");
			wolf.setRating(8);
			Product savedWolf = productRepo.save(wolf);

			Product fox = new Product();
			fox.setName("Fox");
			fox.setDescription("Fantastic. Also superb acting in the Wes Anderson film");
			fox.setEmoji("&#129418;");
			fox.setPrice(35);
			fox.setRegion("field");
			fox.setCompany("Foxy Bingo");
			fox.setRating(6);
			Product savedFox = productRepo.save(fox);

			Product raccoon = new Product();
			raccoon.setName("Raccoon");
			raccoon.setDescription("Eats rubbish. Probably smells like it too, but hey those face markings are dope");
			raccoon.setEmoji("&#129437;");
			raccoon.setPrice(17);
			raccoon.setRegion("field");
			raccoon.setCompany("Raccoon City Pet Store");
			raccoon.setRating(4);
			Product savedRaccoon = productRepo.save(raccoon);

			Product tiger = new Product();
			tiger.setName("Tiger");
			tiger.setDescription("`Can kill a man in seconds`. Jeez big deal who can't?");
			tiger.setEmoji("&#128005;");
			tiger.setPrice(40);
			tiger.setRegion("field");
			tiger.setCompany("Uggs, mugs and tiger rugs");
			tiger.setRating(5);
			Product savedTiger = productRepo.save(tiger);

			Product leopard = new Product();
			leopard.setName("Leopard");
			leopard.setDescription("Huh, just found out a Leopard and a Cheetah aren't the same animal. The more you know!");
			leopard.setEmoji("&#128006;");
			leopard.setPrice(35);
			leopard.setRegion("field");
			leopard.setCompany("Litany of Leopards");
			leopard.setRating(7);
			Product savedLeopard = productRepo.save(whale);

			Product ox = new Product();
			ox.setName("Ox");
			ox.setDescription("Only 1997 kids remember this. Also cracking word to play in Scrabble");
			ox.setEmoji("&#128002;");
			ox.setPrice(32);
			ox.setRegion("field");
			ox.setCompany("We call bull (shipping free)");
			ox.setRating(8);
			Product savedOx = productRepo.save(ox);

			Product waterbuffalo = new Product();
			waterbuffalo.setName("Water Buffalo");
			waterbuffalo.setDescription("ALWAYS pees in the pool");
			waterbuffalo.setEmoji("&#128003;");
			waterbuffalo.setPrice(21);
			waterbuffalo.setRegion("water");
			waterbuffalo.setCompany("Rough, Tough, Buff-alo");
			waterbuffalo.setRating(3);
			Product savedWaterBuffalo = productRepo.save(waterbuffalo);

			Product boar = new Product();
			boar.setName("Boar");
			boar.setDescription("Hakuna Matata baby. It means no worries!");
			boar.setEmoji("&#128023;");
			boar.setPrice(15);
			boar.setRegion("field");
			boar.setCompany("Elon Tusk");
			boar.setRating(6);
			Product savedBoar = productRepo.save(boar);

			Product ram = new Product();
			ram.setName("Ram");
			ram.setDescription("No not random access memory you geek");
			ram.setEmoji("&#128015;");
			ram.setPrice(8);
			ram.setRegion("water");
			ram.setCompany("Ram-packed with Rams (oh god someone please buy one)");
			ram.setRating(5);
			Product savedRam = productRepo.save(ram);

			Product llama = new Product();
			llama.setName("Llama");
			llama.setDescription("Here's a llama there's a llama everywhere a llama llama");
			llama.setEmoji("&#129433;");
			llama.setPrice(28);
			llama.setRegion("field");
			llama.setCompany("Emperor Kuzco's private stash");
			llama.setRating(9);
			Product savedllama = productRepo.save(llama);

			Product elephant = new Product();
			elephant.setName("Elephant");
			elephant.setDescription("Big ears only match their big hearts (and TRUNKS they are ginormous!!)");
			elephant.setEmoji("&#128024;");
			elephant.setPrice(50);
			elephant.setRegion("field");
			elephant.setCompany("Chunky trunky");
			elephant.setRating(9);
			Product savedElephant = productRepo.save(elephant);

			Product rhinoceros = new Product();
			rhinoceros.setName("Rhinoceros");
			rhinoceros.setDescription("Almost as hard to spell as it is to resist making a 'horny' joke");
			rhinoceros.setEmoji("&#129423;");
			rhinoceros.setPrice(75);
			rhinoceros.setRegion("desert");
			rhinoceros.setCompany("Rhino Dynamo");
			rhinoceros.setRating(6);
			Product savedRhino = productRepo.save(rhinoceros);

			Product hippopotamus = new Product();
			hippopotamus.setName("Hippopotamus");
			hippopotamus.setDescription("Greek for 'River Horse'. Funny looking horse but who am I to judge");
			hippopotamus.setEmoji("&#129435;");
			hippopotamus.setPrice(42);
			hippopotamus.setRegion("water");
			hippopotamus.setCompany("Hiphopopotamus");
			hippopotamus.setRating(8);
			Product savedHippo = productRepo.save(hippopotamus);

			// JACK STOP HERE
			/////////////////////////////////////////////////////
			// PARTH START HERE

			Product rat = new Product();
			rat.setName("Rat");
			rat.setDescription("All I need is some cheeeeeeeseeee!");
			rat.setEmoji("&#128000;");
			rat.setPrice(5);
			rat.setRegion("field");
			rat.setCompany("Ratatoullie Co.");
			rat.setRating(1);
			Product savedRat = productRepo.save(rat);

			Product hamster = new Product();
			hamster.setName("Hamster");
			hamster.setDescription("Born to run on a wheel plus we really cute");
			hamster.setEmoji("&#128057;");
			hamster.setPrice(20);
			hamster.setRegion("field");
			hamster.setCompany("Hamster Wheelio");
			hamster.setRating(5);
			Product savedHamster = productRepo.save(hamster);

//			Product chipmunks = new Product();
//			chipmunks.setName("Chipmunks");
//			chipmunks.setDescription("AHWWWOOOOOOOWWWWOOOOEEEEE - Direct quote");
//			chipmunks.setEmoji("&#128063");
//			chipmunks.setPrice(25);
//			chipmunks.setRegion("field");
//			chipmunks.setCompany("Alvin and the Chipmunks");
//			chipmunks.setRating(8);
//			Product savedChipmunks = productRepo.save(chipmunks);

//			Product beaver = new Product();
//			beaver.setName("Beaver");
//			beaver.setDescription("");
//			beaver.setEmoji("&#128051;");
//			beaver.setPrice(60);
//			beaver.setRegion("water");
//			beaver.setCompany("Whale be there for you");
//			beaver.setRating(8);
//			Product savedBeaver = productRepo.save(beaver);

			Product koala = new Product();
			koala.setName("Koala");
			koala.setDescription("The only clingy companion you need this Christmas");
			koala.setEmoji("&#128040;");
			koala.setPrice(30);
			koala.setRegion("field");
			koala.setCompany("Aussieland");
			koala.setRating(6);
			Product savedKoala = productRepo.save(koala);

			Product turkey = new Product();
			turkey.setName("Tukey");
			turkey.setDescription("Thanksgiving's got nothing on me");
			turkey.setEmoji("&#129411;");
			turkey.setPrice(20);
			turkey.setRegion("air");
			turkey.setCompany("Home Oven");
			turkey.setRating(5);
			Product savedTurkey = productRepo.save(turkey);

			Product kangaroo = new Product();
			kangaroo.setName("Kangaroo");
			kangaroo.setDescription("With Kangaroos, you say 'sit' and they start boxing with you!");
			kangaroo.setEmoji("&#129432;");
			kangaroo.setPrice(50);
			kangaroo.setRegion("desert");
			kangaroo.setCompany("World Boxing Federation");
			kangaroo.setRating(7);
			Product savedKangaroo = productRepo.save(kangaroo);

			Product sloth = new Product();
			sloth.setName("Sloth");
			sloth.setDescription("Laziness is nothing more than the habit of resting before you get tired!");
			sloth.setEmoji("&#129445;");
			sloth.setPrice(12);
			sloth.setRegion("field");
			sloth.setCompany("Lazy Planet");
			sloth.setRating(3);
			Product savedSloth = productRepo.save(sloth);

			Product skunk = new Product();
			skunk.setName("Skunk");
			skunk.setDescription("Your personal human repellent");
			skunk.setEmoji("&#129448;");
			skunk.setPrice(10);
			skunk.setRegion("field");
			skunk.setCompany("Axe Deo");
			skunk.setRating(2);
			Product savedSkunk = productRepo.save(skunk);

			Product hedgehog = new Product();
			hedgehog.setName("Hedgehog");
			hedgehog.setDescription("Balloons are my best friends");
			hedgehog.setEmoji("&#129428;");
			hedgehog.setPrice(28);
			hedgehog.setRegion("field");
			hedgehog.setCompany("PartyPopperzz");
			hedgehog.setRating(3);
			Product savedHedgehog = productRepo.save(hedgehog);

			Product chicken = new Product();
			chicken.setName("Chicken");
			chicken.setDescription("BRB - Gonna go get roosted");
			chicken.setEmoji("&#128019;");
			chicken.setPrice(15);
			chicken.setRegion("field");
			chicken.setCompany("KFC");
			chicken.setRating(4);
			Product savedChicken = productRepo.save(chicken);

//			Product whale = new Product();
//			whale.setName("Whale");
//			whale.setDescription("AHWWWOOOOOOOWWWWOOOOEEEEE - Direct quote");
//			whale.setEmoji("&#128051;");
//			whale.setPrice(60);
//			whale.setRegion("water");
//			whale.setCompany("Whale be there for you");
//			whale.setRating(8);
//			Product savedWhale = productRepo.save(whale);
//
//			Product whale = new Product();
//			whale.setName("Whale");
//			whale.setDescription("AHWWWOOOOOOOWWWWOOOOEEEEE - Direct quote");
//			whale.setEmoji("&#128051;");
//			whale.setPrice(60);
//			whale.setRegion("water");
//			whale.setCompany("Whale be there for you");
//			whale.setRating(8);
//			Product savedWhale = productRepo.save(whale);
//
//			Product whale = new Product();
//			whale.setName("Whale");
//			whale.setDescription("AHWWWOOOOOOOWWWWOOOOEEEEE - Direct quote");
//			whale.setEmoji("&#128051;");
//			whale.setPrice(60);
//			whale.setRegion("water");
//			whale.setCompany("Whale be there for you");
//			whale.setRating(8);
//			Product savedWhale = productRepo.save(whale);
//
//			Product whale = new Product();
//			whale.setName("Whale");
//			whale.setDescription("AHWWWOOOOOOOWWWWOOOOEEEEE - Direct quote");
//			whale.setEmoji("&#128051;");
//			whale.setPrice(60);
//			whale.setRegion("water");
//			whale.setCompany("Whale be there for you");
//			whale.setRating(8);
//			Product savedWhale = productRepo.save(whale);
//
//			Product whale = new Product();
//			whale.setName("Whale");
//			whale.setDescription("AHWWWOOOOOOOWWWWOOOOEEEEE - Direct quote");
//			whale.setEmoji("&#128051;");
//			whale.setPrice(60);
//			whale.setRegion("water");
//			whale.setCompany("Whale be there for you");
//			whale.setRating(8);
//			Product savedWhale = productRepo.save(whale);

			// PARTH STOP HERE
			////////////////////////////////////////
			// CHRIS START HERE

			Product duck = new Product();
			duck.setName("Duck");
			duck.setDescription("Duck, duck, goos..., nope, just a duck!");
			duck.setEmoji("&#129414;");
			duck.setPrice(15);
			duck.setRegion("field");
			duck.setCompany("Quack of Dawn Inc.");
			duck.setRating(4);
			Product savedDuck = productRepo.save(duck);

			Product flamingo = new Product();
			flamingo.setName("Flamingo");
			flamingo.setDescription("Wake me up before you Flamingogo...");
			flamingo.setEmoji("&#129449;");
			flamingo.setPrice(300);
			flamingo.setRegion("water");
			flamingo.setCompany("Put Your Foot Down plc");
			flamingo.setRating(8);
			Product savedFlamingo = productRepo.save(flamingo);

			Product crocodile = new Product();
			crocodile.setName("Crocodile");
			crocodile.setDescription("Scary beasts that will always beat you at scrabble! It's because they have all the croc-a-tiles!");
			crocodile.setEmoji("&#128010;");
			crocodile.setPrice(460);
			crocodile.setRegion("water");
			crocodile.setCompany("If The Snap Fits Inc.");
			crocodile.setRating(6);
			Product savedCrocodile = productRepo.save(crocodile);

			Product trex = new Product();
			trex.setName("T-Rex");
			trex.setDescription("Its arms were too short to reach its mouth... but it's still a 10/10 because of the Jurassic Park cameos.");
			trex.setEmoji("&#129430;");
			trex.setPrice(15000);
			trex.setRegion("desert");
			trex.setCompany("Doyouthinkhesaurus Ltd");
			trex.setRating(10);
			Product savedTrex = productRepo.save(trex);

			Product tropicalFish = new Product();
			tropicalFish.setName("Tropical Fish");
			tropicalFish.setDescription("Shark Bait Oooo Aaaaa Aaa");
			tropicalFish.setEmoji("&#128032;");
			tropicalFish.setPrice(300);
			tropicalFish.setRegion("water");
			tropicalFish.setCompany("P. Sherman - 42 Wallaby Way, Sydney");
			tropicalFish.setRating(8);
			Product savedtropicalFish = productRepo.save(tropicalFish);

			Product blowfish = new Product();
			blowfish.setName("Blow Fish");
			blowfish.setDescription("The ringgggg of fireeeee!!");
			blowfish.setEmoji("&#128033;");
			blowfish.setPrice(534);
			blowfish.setRegion("water");
			blowfish.setCompany("P. Sherman - 42 Wallaby Way, Sydney");
			blowfish.setRating(9);
			Product savedBlowFish = productRepo.save(blowfish);

			Product octopus = new Product();
			octopus.setName("Octopus");
			octopus.setDescription("Amazing creatures, watch My Octopus Teacher on Netflix - got a 98% rating on Google...");
			octopus.setEmoji("&#128025;");
			octopus.setPrice(11500);
			octopus.setRegion("water");
			octopus.setCompany("Octopus Energy");
			octopus.setRating(10);
			Product savedOctopus = productRepo.save(octopus);

			Product snail = new Product();
			snail.setName("Snail");
			snail.setDescription("You get $10 million, but for the rest of your life, there is a super snail that is invincible and kills you by touching you. It follows you, trying to kill you. It can board a plane. What would you do?");
			snail.setEmoji("&#128012;");
			snail.setPrice(80000);
			snail.setRegion("field");
			snail.setCompany("Set Snail Ltd.");
			snail.setRating(8);
			Product savedSnail = productRepo.save(snail);

			Product butterfly = new Product();
			butterfly.setName("Butterfly");
			butterfly.setDescription("Fly like a Butterfly, sting like a B(utterfly).");
			butterfly.setEmoji("&#129419;");
			butterfly.setPrice(6930);
			butterfly.setRegion("air");
			butterfly.setCompany("B E A utterfly Inc.");
			butterfly.setRating(10);
			Product savedBufferfly = productRepo.save(butterfly);

			Product bug = new Product();
			bug.setName("Bug");
			bug.setDescription("Bugs are cool. They are important and A Bugs Life is a great watch, 10/10.");
			bug.setEmoji("&#128027;");
			bug.setPrice(2400);
			bug.setRegion("field");
			bug.setCompany("Bugs at Home");
			bug.setRating(5);
			Product savedBug = productRepo.save(bug);

			Product ant = new Product();
			ant.setName("Ant");
			ant.setDescription("Ants, another film I can vaguely remember that changed my view of ants.");
			ant.setEmoji("&#128028;");
			ant.setPrice(1);
			ant.setRegion("field");
			ant.setCompany("Most W-ant-ed plc,");
			ant.setRating(8);
			Product savedAnt = productRepo.save(ant);

			Product ladybug = new Product();
			ladybug.setName("Lady Bug");
			ladybug.setDescription("They are small but are probably quite important. I think everyone likes them.");
			ladybug.setEmoji("&#128030;");
			ladybug.setPrice(5);
			ladybug.setRegion("field");
			ladybug.setCompany("Put It In Your Shopping Bug Inc.");
			ladybug.setRating(6);
			Product savedLadyBug = productRepo.save(ladybug);

			Product flyingSaucer = new Product();
			flyingSaucer.setName("Flying Saucer");
			flyingSaucer.setDescription("We come in peace... but we will abduct your cows...");
			flyingSaucer.setEmoji("&#128760;");
			flyingSaucer.setPrice(5000);
			flyingSaucer.setRegion("mystical");
			flyingSaucer.setCompany("Mars");
			flyingSaucer.setRating(10);
			Product savedFlyingSaucer = productRepo.save(flyingSaucer);

			Cart jackCart = new Cart();
//			jackCart.setUser(savedJack);
			Cart savedJackCart = cartRepo.save(jackCart);

			Cart nickCart = new Cart();
			Cart savedNickCart = cartRepo.save(nickCart);

			User jack = new User();
			jack.setEmail("jack@farmmail.com");
			jack.setUsername("Jackthefarmer");
			jack.setPassword("farmer1");
			jack.setCart(savedJackCart);
			jack.setFarmName("Jack's farm");
			jack.setCredit(100000);
			User savedJack = userRepo.save(jack);

			User nick = new User();
			nick.setEmail("nick@farmmail.com");
			nick.setUsername("Nickthefarmer");
			nick.setPassword("pass");
			nick.setCart(savedNickCart);
			nick.setFarmName("Nick's farm");
			nick.setCredit(100000);
			User savedNick = userRepo.save(nick);

			ProductLine jackLineCow = new ProductLine();
			jackLineCow.setProduct(savedCow);
			jackLineCow.setQuantity(4);
			jackLineCow.setUser(savedJack);
			jackLineCow.setTotalPrice();
			jackLineCow.setInCart(false);
			ProductLine savedJackLineCow = productLineRepo.save(jackLineCow);

			ProductLine jackLineUnicorn= new ProductLine();
			jackLineUnicorn.setProduct(savedUnicorn);
			jackLineUnicorn.setQuantity(1);
			jackLineUnicorn.setUser(savedJack);
			jackLineUnicorn.setTotalPrice();
			jackLineUnicorn.setInCart(false);
			ProductLine savedJackLineUnicorn = productLineRepo.save(jackLineUnicorn);

			ProductLine jackLineDog = new ProductLine();
			jackLineDog.setProduct(savedDog);
			jackLineDog.setQuantity(1);
			jackLineDog.setUser(savedJack);
			jackLineDog.setCart(savedJackCart);
			jackLineDog.setTotalPrice();
			jackLineDog.setInCart(true);
			ProductLine savedJackLineDog = productLineRepo.save(jackLineDog);

		};

	}
}
