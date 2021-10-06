package com.ablackpikatchu.refinement.core.config.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.ablackpikatchu.refinement.Refinement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class JsonConfig {
	
	private static Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
	protected String root = "config/" + Refinement.MOD_ID + "/";
	protected String extension = ".json";

	public void generateConfig() {
		this.reset();

		try {
			this.writeConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private File getConfigFile() {
		return new File(this.root + this.getName() + this.extension);
	}

	public abstract String getName();

	public JsonConfig readConfig() {
		try {
			return GSON.fromJson(new FileReader(this.getConfigFile()), this.getClass());
		} catch (FileNotFoundException e) {
			this.generateConfig();
		}

		return this;
	}

	protected abstract void reset();

	public void writeConfig() throws IOException {
		File dir = new File(this.root);
		if(!dir.exists() && !dir.mkdirs())return;
		if(!this.getConfigFile().exists() && !this.getConfigFile().createNewFile())return;
		FileWriter writer = new FileWriter(this.getConfigFile());
		GSON.toJson(this, writer);
		writer.flush();
		writer.close();
	}


}
