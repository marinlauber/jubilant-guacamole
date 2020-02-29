# -*- coding: utf-8 -*-
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import os
from matplotlib.backends.backend_pdf import PdfPages

def read(fname): return pd.read_csv(fname)


def plot_hist(pdf, fname):
    df = read(fname)
    if(df.columns[0]=='Iteration'):
        df.set_index(df.columns[0]).plot(lw=0.5, logy=True)
    else:
        df = df.set_index(df.columns[0])
        mean = df.drop(df.index[:-100]).mean()[0]
        df.plot(lw=0.5, logy=False)
        plt.ylim([min(0.5*mean,1.5*mean),
                  max(0.5*mean,1.5*mean)])
    plt.ylabel(fname[:-4])
    plt.tight_layout()
    pdf.savefig()
    plt.close()
        

if __name__=="__main__":     
    with PdfPages('history.pdf') as pdf:
        for file in os.listdir("."):
            if(file[-3:] == 'csv'):
                plot_hist(pdf,file)
