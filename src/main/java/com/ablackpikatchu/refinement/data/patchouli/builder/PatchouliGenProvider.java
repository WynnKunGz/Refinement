package com.ablackpikatchu.refinement.data.patchouli.builder;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;

public abstract class PatchouliGenProvider implements IDataProvider {

	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
	private static final Logger LOGGER = LogManager.getLogger();
	public final DataGenerator generator;

	public final String modid;
	public final String language;
	public final String bookName;

	public ArrayList<PatchouliEntry> entries = new ArrayList<>();
	public ArrayList<PatchouliCatgory> categories = new ArrayList<>();

	public PatchouliGenProvider(DataGenerator generator, String modid, String language, String bookName) {
		this.generator = generator;
		this.modid = modid;
		this.language = language;
		this.bookName = bookName;
	}

	@Override
	public void run(DirectoryCache pCache) throws IOException {
		addEntries();
		writeEntries(pCache);
		
		addCategories();
		writeCategories(pCache);
	}

	private void writeEntries(DirectoryCache cache) {
		Path outputFolder = this.generator.getOutputFolder();
		entries.forEach(entry -> {
			Path path = outputFolder.resolve("data/" + modid + "/patchouli_books/" + bookName + "/" + language + "/entries/"
					+ entry.category + "/" + entry.fileName + ".json");
			try {
				IDataProvider.save(GSON, cache, entry.serialize(), path);
			} catch (IOException e) {
				LOGGER.error("Couldn't generate entry!", path, (Object) e);
			}
		});
	}
	
	private void writeCategories(DirectoryCache cache) {
		Path outputFolder = this.generator.getOutputFolder();
		categories.forEach(category -> {
			Path path = outputFolder.resolve("data/" + modid + "/patchouli_books/" + bookName + "/" + language + "/categories/"
					+ category.fileName + ".json");
			try {
				IDataProvider.save(GSON, cache, category.serialize(), path);
			} catch (IOException e) {
				LOGGER.error("Couldn't generate category!", path, (Object) e);
			}
		});
	}

	@Nullable
	public abstract void addEntries();
	@Nullable
	public abstract void addCategories();

	@Override
	public String getName() {
		return "PatchouliGenProvider";
	}

}
