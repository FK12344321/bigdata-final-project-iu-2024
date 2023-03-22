This repository is a template for the final project of big data course in IU-2023. It contains the following directories:

- `data/` contains the dataset files.
- `models/` contains the ML models.
- `notebooks/` has the Jupyter or Zeppelin notebooks of your project.
- `output/` represents the output directory for storing the results of the project. It can contain `csv` files, text files. images and any other materials you returned as an ouput of the pipeline.
- `scripts/` is a place for storing `.sh` scripts and `.py` scripts.
- `sql/` is a folder for keeping all `.sql` and `.hql` files.

`main.sh` is the main script that will run the script `scripts/run.sh` which will execute the full pipeline and store the results in `output/` folder. During checking your project repo, the grader will run only the main script and check the results in `output/` folder.

**Important Note:** You cannot change the content of the script `main.sh` since it will be used for assessment purposes.